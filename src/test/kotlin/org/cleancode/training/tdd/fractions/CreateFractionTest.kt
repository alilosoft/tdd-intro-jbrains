package org.cleancode.training.tdd.fractions

import org.junit.Test
import kotlin.test.assertEquals


internal class CreateFractionTest {

    @Test(expected = AssertionError::class)
    fun denominatorMustNotEqualToZero() {
        Fraction(0, 0)
    }

    @Test
    fun usingOverFunctionWithInfixNotation() {
        assertEquals(Fraction(1, 2), 1 over 2)
        assertEquals(Fraction(3, 5), 3 over 5)
    }

}