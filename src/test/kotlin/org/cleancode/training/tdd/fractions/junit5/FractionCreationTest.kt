package org.cleancode.training.tdd.fractions.junit5

import org.cleancode.training.tdd.fractions.over
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class FractionCreationTest {
    @Test
    fun whenDenominatorZeroThrowsException() {
        val error = assertThrows<AssertionError>("Denominator can't be Zero") {
            1 over 0
        }
        assertEquals("Denominator can't be Zero", error.message)
    }

}