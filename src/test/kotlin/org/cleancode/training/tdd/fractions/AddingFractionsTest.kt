package org.cleancode.training.tdd.fractions

import kotlin.test.Test
import kotlin.test.assertEquals

internal class AddingFractionsTest {

    @Test(expected = AssertionError::class)
    fun denominatorMustNotEqualToZero() {
        Fraction(0, 0)
    }

    @Test
    fun additionWhenDenominatorIsOne() {
        var expected = Fraction(0)
        var actual = Fraction(0).add(Fraction(0))
        assertEquals(expected, actual)

        expected = Fraction(2)
        actual = Fraction(1).add(Fraction(1))
        assertEquals(expected, actual)

        expected = Fraction(7)
        actual = Fraction(3).add(Fraction(4))
        assertEquals(expected, actual)
    }

    @Test
    fun additionWhenDenominatorsAreEqual() {
        val expected = Fraction(5, 7)
        val actual = Fraction(3, 7).add(Fraction(2, 7))
        assertEquals(expected, actual)
    }

    @Test
    fun additionWhenDenominatorsAreDifferent() {
        val expected = Fraction(numerator = 47, denominator = 15)
        val actual = Fraction(7, 3).add(Fraction(4, 5))
        assertEquals(expected, actual)
    }

    @Test
    fun additionAndConversionToLowestTerm() {
        val expected = Fraction(numerator = 13, denominator = 18)
        val actual = Fraction(3, 6).add(Fraction(2, 9))
        assertEquals(expected, actual)
    }

}