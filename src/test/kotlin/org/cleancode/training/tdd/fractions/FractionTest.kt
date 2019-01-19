package org.cleancode.training.tdd.fractions

import kotlin.test.Test
import kotlin.test.assertEquals

internal class FractionTest {
    @Test fun addFractions() {
//        assertEquals(Fraction(numerator = 47, denominator = 15),
//                Fraction(7, 3).add(Fraction(4, 5)))
    }

    @Test fun addWithDenominatorIsOne() {
        assertEquals(Fraction(7),
                Fraction(3).add(Fraction(4)))

        assertEquals(Fraction(9),
                Fraction(5).add(Fraction(4)))
    }
}