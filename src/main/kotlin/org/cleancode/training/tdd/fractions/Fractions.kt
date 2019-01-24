package org.cleancode.training.tdd.fractions

import kotlin.math.abs
import kotlin.math.min

infix fun Int.over(denominator: Int) = Fraction(this, denominator)

data class Fraction(var numerator: Int, var denominator: Int = 1) {
    init {
        assert(denominator != 0) { "Denominator can't be Zero" }
        if (denominator < 0) {
            denominator *= -1
            numerator *= -1
        }
    }

    fun add(other: Fraction): Fraction {
        val rNumerator: Int
        val rDenominator: Int

        if (this.denominator == other.denominator) {
            rNumerator = this.numerator + other.numerator
            rDenominator = this.denominator
        } else {
            // unify the denominator
            rNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            rDenominator = this.denominator * other.denominator
        }

        return Fraction(rNumerator, rDenominator).lowestTerm()
    }

    private fun reduce(): Fraction {
        val gcd = gcd(numerator, denominator)
        numerator /= gcd
        denominator /= gcd
        return this
    }

}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) abs(a) else gcd(b, a % b)
}
