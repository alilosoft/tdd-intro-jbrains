package tdd.intro.jbrains.fractions

import kotlin.test.Test
import kotlin.test.assertEquals

internal class FractionTest {
    @Test
    fun addFractions() {
        assertEquals(Fraction(nomerator = 47, denomerator = 15),
                Fraction(7, 3).add(Fraction(4, 5)))
    }
}