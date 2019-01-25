package org.cleancode.training.tdd.fractions

import org.junit.Test
import kotlin.test.assertEquals

class MultiplyFractionsTest {
    @Test
    fun multiplyByZeroShouldAlwaysReturnZero() {
        assertEquals(Fraction(0), Fraction(0).multiply(Fraction(0)))
        assertEquals(Fraction(0), Fraction(0).multiply(Fraction(1)))
        assertEquals(Fraction(0), Fraction(1).multiply(Fraction(0)))
        assertEquals(Fraction(0), Fraction(0).multiply(Fraction(123456)))
    }

    @Test
    fun multiplyByOneShouldHaveNoEffect() {
        assertEquals(Fraction(1), Fraction(1) * (Fraction(1)))
        assertEquals(Fraction(2), Fraction(1) * (Fraction(2)))
        assertEquals(1 over 2, Fraction(1) * (1 over 2))
    }
}