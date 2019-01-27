package org.cleancode.training.tdd.fractions.kotlintest

import org.cleancode.training.tdd.fractions.gcd
import org.junit.Test
import kotlin.test.assertEquals

class GCDCalculationTest {

    @Test
    fun gcdEqualsOne() {
        assertEquals(1, gcd(3, 2))
        assertEquals(1, gcd(3, 4))
        assertEquals(1, gcd(4, 9))
    }

    @Test
    fun gcdNotEqualsOne() {
        assertEquals(3, gcd(9, 6))
        assertEquals(3, gcd(3, 9))
        assertEquals(5, gcd(5, 15))
        assertEquals(3, gcd(39, 54))
        assertEquals(12, gcd(48, 180))
        assertEquals(6, gcd(48, 18))
        assertEquals(18, gcd(0, 18))
    }

    @Test
    fun gcdShouldAlwaysBePositive() {
        assertEquals(3, gcd(-9, 6))
        assertEquals(5, gcd(5, -15))
        assertEquals(3, gcd(-39, -54))
    }

}
