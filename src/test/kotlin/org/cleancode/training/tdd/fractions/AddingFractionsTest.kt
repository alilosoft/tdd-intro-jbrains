package org.cleancode.training.tdd.fractions

import kotlin.test.Test
import kotlin.test.assertEquals

internal class AddingFractionsTest {

    @Test
    fun whenDenominatorIsOne() {
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
    fun whenDenominatorsAreEqual() {
        val expected = Fraction(5, 7)
        val actual = Fraction(3, 7).add(Fraction(2, 7))
        assertEquals(expected, actual)
    }

    @Test
    fun whenDenominatorsAreDifferent() {
        val expected = Fraction(numerator = 47, denominator = 15)
        val actual = Fraction(7, 3).add(Fraction(4, 5))
        assertEquals(expected, actual)
    }

    @Test
    fun convertingResultToLowestTerm() {
        val expected = Fraction(numerator = 13, denominator = 18)
        val actual = Fraction(3, 6).add(Fraction(2, 9))
        assertEquals(expected, actual)
    }

    @Test
    fun whenNumeratorIsNegativeWithSameDenominator() {
        assertEquals(Fraction(0), Fraction(-1).add(Fraction(1)))
        assertEquals(Fraction(1), Fraction(-1).add(Fraction(2)))
        assertEquals(Fraction(1, 2), Fraction(-1, 2).add(Fraction(1)))
        assertEquals(Fraction(1, 2), Fraction(-1, 2).add(Fraction(1, 2)))
        assertEquals(Fraction(-5, 6),
                Fraction(-7, 10).add(Fraction(-2, 15)))
    }

    @Test
    fun whenDenominatorIsNegative() {
        assertEquals(Fraction(-5, 6), Fraction(7, -10).add(Fraction(2, -15)))
    }

    @Test
    fun whenNumeratorAndDenominatorAreNegative() {
        assertEquals(Fraction(7, 10), Fraction(-7, -10).add(Fraction(0)))
        assertEquals(Fraction(6, 5), Fraction(-7, -10).add(Fraction(1, 2)))
    }

}