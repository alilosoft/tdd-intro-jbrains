package org.cleancode.training.tdd.fractions

import kotlin.math.abs

infix fun Int.over(denominator: Int) = Fraction(this, denominator)

data class Fraction(var numerator: Int, var denominator: Int = 1) {
    init {
        assert(denominator != 0) { "Denominator can't be Zero" }
        reduce()
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
        return Fraction(rNumerator, rDenominator)
    }

    private fun reduce() {
        val gcd = gcd(numerator, denominator)
        val denominatorSign = if (denominator < 0 ) -1 else  1
        numerator /= gcd * denominatorSign
        denominator /= gcd * denominatorSign
    }

}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) abs(a) else gcd(b, a % b)
}
