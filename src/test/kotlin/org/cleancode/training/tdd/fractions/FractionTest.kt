package org.cleancode.training.tdd.fractions

import kotlin.math.min
import kotlin.test.Test
import kotlin.test.assertEquals

internal class FractionTest {

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
    fun additionAndConversionToLowerTerm() {
        val expected = Fraction(numerator = 13, denominator = 18)
        val actual = Fraction(3, 6).add(Fraction(2, 9))
        assertEquals(expected, actual)
    }

    @Test
    fun testGCDEqualsOne() {
        assertEquals(1, calcGCD(2, 5))
    }

    @Test
    fun testGCDNotEqualsOne() {
        assertEquals(3, calcGCD(6, 9))
        assertEquals(3, calcGCD(3, 9))
        assertEquals(5, calcGCD(5, 15))
        assertEquals(3, calcGCD(39, 54))
    }





}