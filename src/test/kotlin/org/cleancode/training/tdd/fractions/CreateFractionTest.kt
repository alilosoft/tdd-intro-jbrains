package org.cleancode.training.tdd.fractions

import org.junit.Test


internal class CreateFractionTest {

    @Test(expected = AssertionError::class)
    fun denominatorMustNotEqualToZero() {
        Fraction(0, 0)
    }

}