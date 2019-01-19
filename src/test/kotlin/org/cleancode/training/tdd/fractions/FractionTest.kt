package org.cleancode.training.tdd.fractions

import kotlin.test.Test
import kotlin.test.assertEquals

internal class FractionTest {
//    @Test fun addFractions() {
//        assertEquals(Fraction(numerator = 47, denominator = 15),
//                Fraction(7, 3).add(Fraction(4, 5)))
//    }

    @Test fun additionWhenDenominatorIsOne() {
        assertEquals(Fraction(7),
                Fraction(3).add(Fraction(4)))
    }

    @Test fun additionWhenDenominatorsAreEqual() {
        assertEquals(Fraction(5, 7),
                Fraction(3, 7).add(Fraction(2, 7)))
    }

}