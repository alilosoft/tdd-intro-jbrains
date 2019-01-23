package org.cleancode.training.tdd.fractions

import org.junit.Test
import kotlin.test.assertEquals

class FractionsEqualityTest {
    @Test
    fun oneWithNegativeNumeratorAndOtherWithNegativeDenominator() {
        assertEquals(-1 over 2 , 1 over -2)
        assertEquals(1 over -2 , -1 over 2)
    }

    @Test
    fun negativeNumeratorAndDenominator() {
        assertEquals(-1 over -2 , 1 over 2)
    }
}