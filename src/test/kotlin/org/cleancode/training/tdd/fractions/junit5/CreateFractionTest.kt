package org.cleancode.training.tdd.fractions.junit5

import org.assertj.core.api.Assertions.assertThat
import org.cleancode.training.tdd.fractions.DENOMINATOR_ZERO_ERROR
import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.aggregator.AggregateWith
import org.junit.jupiter.params.aggregator.ArgumentsAccessor
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException
import org.junit.jupiter.params.aggregator.ArgumentsAggregator
import org.junit.jupiter.params.converter.ArgumentConversionException
import org.junit.jupiter.params.converter.ArgumentConverter
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Create fractions")
class CreateFractionTest {

    @DisplayName("Throw an Exception if Denominator is Zero")
    @Test
    fun whenDenominatorZeroThrowsException() {
        val error = assertThrows<AssertionError> {
            1 over 0
        }
        assertEquals(DENOMINATOR_ZERO_ERROR, error.message)
    }

    // using args converter
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = ["1/2"])
    fun `Implicit String Conversion to Fraction`(f: Fraction) {
        assertThat(f).isEqualTo(1 over 2)
    }

    // using args converter
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = ["1/2", "1/4", "1/1", "-1/2", "1/-4"])
    fun `Fraction From String (ArgsConverter)`(@ConvertToFraction f: Fraction) {
        assertThat(f).isNotNull
    }

    // using args accessor
    @ParameterizedTest
    @CsvSource("0", "1", "1, 2", "-2, 3", "1, -4")
    fun `Fraction From String (ArgsAccessor)`(args: ArgumentsAccessor) {
        val f = if (args.size() == 1) Fraction(args.getInteger(0)) else Fraction(args.getInteger(0), args.getInteger(1))
        assertThat(f).isNotNull
    }

    // using args aggregator
    @ParameterizedTest
    @CsvSource("0", "1", "1, 2", "-2, 3", "1, -4")
    fun `Fraction From String (ArgsAggregator)`(@AggregateToFraction f: Fraction) {
        assertThat(f).isNotNull
    }

}

object FractionConverter : ArgumentConverter {
    override fun convert(source: Any?, context: ParameterContext?): Fraction {
        val errorMess = "Can't convert $source to Fraction!"
        if (source is String && source.isNotEmpty()) {
            try {
                return Fraction.parse(source)
            } catch (e: NumberFormatException) {
                throw ArgumentConversionException(errorMess)
            }
        } else throw ArgumentConversionException(errorMess)
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@ConvertWith(FractionConverter::class)
annotation class ConvertToFraction

object FractionAgregator : ArgumentsAggregator {
    override fun aggregateArguments(args: ArgumentsAccessor?, context: ParameterContext?): Any {
        if (args != null) {
            return if (args.size() == 1)
                Fraction(args.getInteger(0))
            else
                Fraction(args.getInteger(0), args.getInteger(1))
        } else
            throw ArgumentsAggregationException("")
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@AggregateWith(FractionAgregator::class)
annotation class AggregateToFraction