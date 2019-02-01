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

/**
 * Show case of using JUnit 5 parametrized tests with
 * custom arguments providers and meta-annotations
 */
class MultiplyFractionsTest {


    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @ArgumentsSource(MultiplyByZeroTestData::class)
    fun multiplyFractionsByZero(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @ArgumentsSource(MultiplyByOneTestData::class)
    fun multiplyFractionsByOne(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @ArgumentsSource(PositiveFractionsTestData::class)
    fun multiplyPositiveFractions(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} should be {2}")
    @NegativeFractionsArgs
    fun multiplyNegativeFractions(f1: Fraction, f2: Fraction, result: Fraction) {
        assertThat(f1 * f2).isEqualTo(result)
    }

}

val allTestsData = arrayOf(
        arrayOf(Fraction(0), Fraction(0), Fraction(0)),
        arrayOf(Fraction(0), 1 over 2, Fraction(0)),
        arrayOf(Fraction(1), Fraction(1), Fraction(1)),
        arrayOf(Fraction(1), 1 over 2, 1 over 2),
        arrayOf(1 over 2, 1 over 2, 1 over 4),
        arrayOf(3 over 2, 2 over 3, 1 over 1),
        arrayOf(-1 over 2, 1 over 3, -1 over 6),
        arrayOf(-1 over 2, -1 over 2, 1 over 4)
)

/**
 * Filter the test data array using the given @predicate
 * and convert the result to Stream of Arguments
 * @return Stream of Arguments
 */
fun testDataToArgsStream(predicate: (Fraction) -> Boolean) =
        allTestsData.filter { it.any(predicate) }.map { Arguments.of(*it) }.stream()

object MultiplyByZeroTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?) =
            testDataToArgsStream { f -> f.numerator == 0 }
}

object MultiplyByOneTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?) =
            testDataToArgsStream { it == Fraction(1) }
}

object PositiveFractionsTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?) =
            testDataToArgsStream { it.denominator != 1 && it.numerator != 0 }
}

object NegativeFractionsTestData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?) =
            testDataToArgsStream { it.numerator < 0 }
}

// custom annotation
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@ArgumentsSource(NegativeFractionsTestData::class)
annotation class NegativeFractionsArgs

