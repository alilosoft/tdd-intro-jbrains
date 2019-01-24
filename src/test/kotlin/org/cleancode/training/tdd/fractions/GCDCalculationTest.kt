package org.cleancode.training.tdd.fractions

import org.junit.Test
import kotlin.test.assertEquals

class GCDCalculationTest {
    @Test
    fun testGCDEqualsOne() {
        assertEquals(1, calcGCD(2, 5))
    }

    @Test
    fun testGCDNotEqualsOne() {
        assertEquals(3, calcGCD(6, 9))
        assertEquals(3, calcGCD(3, 9))
        assertEquals(5, calcGCD(5, 15))
        assertEquals(3, calcGCD(39, 54))
        assertEquals(12, calcGCD(48, 180))
        assertEquals(12, calcGCD(24, 60))
        assertEquals(6, calcGCD(48, 18))
    }

    @Test
    fun gcdNotEqualsToOne() {
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
