package org.cleancode.training.tdd.fractions.junit5

import org.cleancode.training.tdd.fractions.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class FractionCreationTest {
    @Test
    fun whenDenominatorZeroThrowsException() {
        val error = assertThrows<AssertionError>("Denominator can't be Zero") {
            1 over 0
        }
        assertEquals("Denominator can't be Zero", error.message)
    }

    @Test
    fun `Fractions Should Always Created In Lowest Term`() {
        assertAll("reduce fractions when created",
                { assertEquals(1 over 2, 2 over 4) { "2/4 should be reduced to 1/2" } },
                { assertEquals(1 over 2, 4 over 8) },
                { assertEquals(1 over 2, 2 over 4) },
                { assertEquals(1 over 2, 4 over 8) })
    }

}