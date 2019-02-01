package org.cleancode.training.tdd.fractions.junit5

import org.assertj.core.api.Assertions.assertThat
import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.cleancode.training.tdd.fractions.times
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream


class MultiplyFractionsTest {

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @MultiplyByZeroArgs //or: @ArgumentsSource(MultiplyByZeroTestData::class)
    fun multiplyByZeroShouldAlwaysReturnZero(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @ArgumentsSource(MultiplyByOneTestData::class)
    fun multiplyFractionsByOne(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @ArgumentsSource(MultiplyPositiveTestData::class)
    fun multiplyPositiveFractions(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @ArgumentsSource(MultiplyNegativeTestData::class)
    fun multiplyNegativeFractions(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

}

val multiplications = listOf(
        arrayOf(Fraction(0), Fraction(0), Fraction(0)),
        arrayOf(Fraction(0), 1 over 2, Fraction(0)),
        arrayOf(Fraction(1), Fraction(1), Fraction(1)),
        arrayOf(Fraction(1), 1 over 2, 1 over 2),
        arrayOf(1 over 2, 1 over 2, 1 over 4),
        arrayOf(3 over 2, 2 over 3, 1 over 1),
        arrayOf(-1 over 2, 1 over 3, -1 over 6),
        arrayOf(-1 over 2, -1 over 2, 1 over 4)
)

fun argsStream(predicate: (Array<Fraction>) -> Boolean) = multiplications.filter(predicate).map { Arguments.of(*it) }.stream()

object MultiplyByZeroTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return argsStream { it.any { f -> f.numerator == 0 } }
//        multiplications
//                .filter { it.any { f -> f.numerator == 0 } }
//                .map { Arguments.of(*it) }.stream()
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@ArgumentsSource(MultiplyByZeroTestData::class)
annotation class MultiplyByZeroArgs

object MultiplyByOneTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return multiplications
                .filter { it.any { f -> f.denominator == 1 && f.numerator == 1 } }
                .map { Arguments.of(*it) }.stream()
    }
}

object MultiplyPositiveTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return multiplications
                .filter { it.any { f -> f.denominator != 1 && f.numerator != 0 } }
                .map { Arguments.of(*it) }.stream()
    }
}

object MultiplyNegativeTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return multiplications
                .filter { it.any { f -> f.numerator < 0 } }
                .map { Arguments.of(*it) }.stream()
    }
}

