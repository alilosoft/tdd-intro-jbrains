package org.cleancode.training.tdd.fractions

import kotlin.math.min

data class Fraction(val numerator: Int, val denominator: Int = 1) {
    init {
        assert(denominator != 0) {"Denominator can't be Zero"}
    }

    fun add(other: Fraction): Fraction {
        var rNumerator: Int
        var rDenominator: Int

        if (this.denominator == other.denominator) {
            rNumerator = this.numerator + other.numerator
            rDenominator = this.denominator
        } else {
            // calc common denominator
            rNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            rDenominator = this.denominator * other.denominator
        }
        // calc lowest term
        val gcd = calcGCD(rNumerator, rDenominator)
        if (gcd > 1) {
            rNumerator /= gcd
            rDenominator /= gcd
        }
        return Fraction(rNumerator, rDenominator)
    }

}

fun calcGCD(n1: Int, n2: Int): Int {
    var gcd = 1
    val min = min(n1, n2)

    for (g in 2..min) {
        if (n1 % g == 0 && n2 % g == 0) {
            gcd = g
        }
    }
    return gcd
}
