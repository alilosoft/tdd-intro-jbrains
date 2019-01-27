package org.cleancode.training.tdd.fractions.kotlintest

import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.junit.Test
import kotlin.test.assertEquals


internal class FractionCreationTest {

    @Test(expected = AssertionError::class)
    fun denominatorMustNotEqualToZero() {
        Fraction(0, 0)
    }

    @Test
    fun usingOverFunctionWithInfixNotation() {
        assertEquals(Fraction(1, 2), 1 over 2)
        assertEquals(Fraction(3, 5), 3 over 5)
    }

    @Test
    fun whenDenominatorIsNegativeThenMoveMinusSignToNumerator() {
        assertEquals(-1 over 2 , 1 over -2)
    }

    @Test
    fun whenNumeratorAndDenominatorAreNegative() {
        assertEquals(-1 over -2 , 1 over 2)
    }

    @Test
    fun reduceFractionToItsLowestTerm() {
        assertEquals(1 over 2 , 2 over 4)
        assertEquals(1 over 2 , 4 over 8)
        assertEquals(1 over 2 , 5 over 10)
    }

}