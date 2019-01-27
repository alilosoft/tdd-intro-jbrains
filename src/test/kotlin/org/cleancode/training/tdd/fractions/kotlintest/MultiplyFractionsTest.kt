package org.cleancode.training.tdd.fractions.kotlintest

import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.cleancode.training.tdd.fractions.times
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

    @Test
    fun nonZeroAndNonOneOperands() {
        assertEquals(1 over 4, (1 over 2) * (1 over 2))
        assertEquals(2 over 15, (1 over 3) * (2 over 5))
    }

    @Test
    fun reduceResult() {
        assertEquals(1 over 2, (2 over 3) * (3 over 4))
        assertEquals(1 over 3, (2 over 3) * (1 over 2))
    }
}