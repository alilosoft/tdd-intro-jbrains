package org.cleancode.training.tdd.fractions.kotlintest

import org.cleancode.training.tdd.fractions.gcdOf
import org.junit.Test
import kotlin.test.assertEquals

class GCDCalculationTest {

    @Test
    fun gcdEqualsOne() {
        assertEquals(1, gcdOf(3, 2))
        assertEquals(1, gcdOf(3, 4))
        assertEquals(1, gcdOf(4, 9))
    }

    @Test
    fun gcdNotEqualsOne() {
        assertEquals(3, gcdOf(9, 6))
        assertEquals(3, gcdOf(3, 9))
        assertEquals(5, gcdOf(5, 15))
        assertEquals(3, gcdOf(39, 54))
        assertEquals(12, gcdOf(48, 180))
        assertEquals(6, gcdOf(48, 18))
        assertEquals(18, gcdOf(0, 18))
    }

    @Test
    fun gcdShouldAlwaysBePositive() {
        assertEquals(3, gcdOf(-9, 6))
        assertEquals(5, gcdOf(5, -15))
        assertEquals(3, gcdOf(-39, -54))
    }

}
