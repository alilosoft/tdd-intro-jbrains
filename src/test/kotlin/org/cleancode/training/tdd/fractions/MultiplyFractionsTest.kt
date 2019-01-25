package org.cleancode.training.tdd.fractions

import org.junit.Test
import kotlin.test.assertEquals

class MultiplyFractionsTest {
    @Test
    fun zeroFractions() {
        assertEquals(Fraction(0), Fraction(0).multiply(Fraction(0)))
        assertEquals(Fraction(0), Fraction(0).multiply(Fraction(1)))
        assertEquals(Fraction(0), Fraction(1).multiply(Fraction(0)))
    }
}