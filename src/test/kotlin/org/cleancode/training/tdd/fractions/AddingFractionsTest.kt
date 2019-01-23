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
    fun whenNumeratorIsNegativeAndDenominatorIsOne() {
        assertEquals(Fraction(0), Fraction(-1).add(Fraction(1)))
        assertEquals(Fraction(-2), Fraction(-1).add(Fraction(-1)))
    }

    @Test
    fun whenNumeratorIsNegative() {
        assertEquals(Fraction(0), (-1 over 2).add(1 over 2))
        assertEquals(-5 over 6, (-7 over 10).add(-2 over 15))
    }

    @Test
    fun whenDenominatorAreSameAndNegative() {
        assertEquals(-7 over 5, (3 over -5).add(4 over -5))
        assertEquals(7 over 5, (-3 over -5).add(-4 over -5))
        assertEquals(-1 over 5, (-3 over -5).add(4 over -5))
        assertEquals(1 over 5, (3 over -5).add(-4 over -5))
    }

    @Test
    fun whenDenominatorHaveDifferentSigns() {
        assertEquals(-1 over 5, (3 over 5).add(4 over -5))
        assertEquals(-7 over 5, (-3 over 5).add(4 over -5))
        assertEquals(1 over 5, (3 over -5).add(4 over 5))
    }

    @Test
    fun whenDenominatorAreDifferentAndNegative() {
        assertEquals(-5 over 6, (7 over -10).add(2 over -15))
    }

    @Test
    fun whenNumeratorAndDenominatorAreNegative() {
        assertEquals(7 over 10, (-7 over -10).add(Fraction(0)))
        assertEquals(6 over 5, (-7 over -10).add(1 over 2))
    }

}