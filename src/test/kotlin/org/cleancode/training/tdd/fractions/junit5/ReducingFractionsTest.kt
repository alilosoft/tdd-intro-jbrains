package org.cleancode.training.tdd.fractions.junit5

import org.assertj.core.api.Assertions.assertThat
import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

// change test life cycle to PER_CLASS to allow non-static
// methods as MethodSource for ParametrizedTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// or using custom annotation: @NonStaticMethodSource
// or using junit-platform.properties
@DisplayName("Fractions Should Always Reduced To Lowest Term")
class ReducingFractionsTest {

    // non-static MethodSource can be used for parametrized test
    // this is possible because of TestInstance.Lifecycle.PER_CLASS above
    @DisplayName("Reducing (Non-Static Method Source)")
    @ParameterizedTest(name = "{0}/{1} should be reduced to {2}")
    @MethodSource("fractionsTestData")
    fun `Reducing Fractions (Non-Static)`(numerator: Int, denominator: Int, reduced: Fraction) {
        assertThat(Fraction(numerator, denominator)).isEqualTo(reduced)
    }

    // non-static method source
    fun fractionsTestData() = arrayOf(
            arguments(2, 4, 1 over 2),
            arguments(9, 15, 3 over 5))

    // Using companion object to define static method source
    companion object {
        @JvmStatic
        fun testDataCompanion() = arrayOf(
                Arguments.of(2, 4, 1 over 2),
                Arguments.of(5, 15, 1 over 3))
    }

    @DisplayName("Reducing (Companion Object Method Source)")
    @ParameterizedTest(name = "{0}/{1} should be reduced to {2}")
    @MethodSource("testDataCompanion")
    fun `Reducing Fractions (Companion Object)`(numerator: Int, denominator: Int, reduced: Fraction) {
        assertThat(Fraction(numerator, denominator)).isEqualTo(reduced)
    }

    // Using external class method as MethodSource
    @DisplayName("Reducing (External Method Source)")
    @ParameterizedTest(name = "{0}/{1} should be reduced to {2}")
    @MethodSource("data.MethodSources#reducableFractions")
    fun `Reducing Fractions (External Method Source)`(numerator: Int, denominator: Int, reduced: Fraction) {
        assertThat(Fraction(numerator, denominator)).isEqualTo(reduced)
    }

    // Using custom annotation @FractionsMethodSource to define method source
    @DisplayName("Reducing (Meta-Annotation Method Source)")
    @ParameterizedTest(name = "{0}/{1} should be reduced to {2}")
    @FractionsMethodSource // meta-annotation
    fun `Reducing Fractions (Meta-Annotation)`(numerator: Int, denominator: Int, reduced: Fraction) {
        assertThat(Fraction(numerator, denominator)).isEqualTo(reduced)
    }

}