package org.cleancode.training.tdd.fractions.junit5

import org.assertj.core.api.Assertions.assertThat
import org.cleancode.training.tdd.fractions.gcdOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("GCD Calculations")
class GCDTest {

    @DisplayName("GCD should equal to one")
    @ParameterizedTest(name = "[{index}] gcdOf({0} ,{1})  should be 1")
    @CsvSource("2, 3", "3, 4", "4, 5", "7, 9")
    fun gcdShouldBeOne(a: Int, b: Int) {
        assertThat(gcdOf(a, b)).isEqualTo(1)
    }

    @ParameterizedTest(name = "[{index}] gcdOf({0} ,{1})  should be {2}")
    @CsvFileSource(resources = ["/gcd.csv"])
    fun gcdNotEqualOne(a: Int, b: Int, gcd: Int) {
        assertThat(gcdOf(a, b)).isEqualTo(gcd)
    }
}