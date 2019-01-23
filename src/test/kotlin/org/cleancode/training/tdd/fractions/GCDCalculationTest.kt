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
    fun testEuclideanGCDNotEqualsOne() {
        assertEquals(3, euclideanGCD(9, 6))
        assertEquals(3, euclideanGCD(3, 9))
        assertEquals(5, euclideanGCD(5, 15))
        assertEquals(3, euclideanGCD(39, 54))
        assertEquals(12, euclideanGCD(48, 180))
        assertEquals(12, euclideanGCD(24, 60))
        assertEquals(6, euclideanGCD(48, 18))
        assertEquals(18, euclideanGCD(0, 18))
        assertEquals(18, euclideanGCD(18, 0))
    }

}
