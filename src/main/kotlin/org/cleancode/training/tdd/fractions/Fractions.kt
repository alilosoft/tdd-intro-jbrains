package org.cleancode.training.tdd.fractions

infix fun Int.over(denominator: Int) = Fraction(this, denominator)

data class Fraction(var numerator: Int, var denominator: Int = 1) {
    init {
        assert(denominator != 0) { "Denominator can't be Zero" }
        val gcd = gcd(numerator, denominator)
        val denominatorSign = if (denominator < 0 ) -1 else  1
        numerator /= gcd * denominatorSign
        denominator /= gcd * denominatorSign
    }

    fun add(other: Fraction): Fraction {
        val rNumerator = this.numerator * other.denominator + other.numerator * this.denominator
        val rDenominator = this.denominator * other.denominator
        return Fraction(rNumerator, rDenominator)
    }

    fun multiply(other: Fraction): Fraction {
        return  Fraction(this.numerator * other.numerator, this.denominator * other.denominator)
    }

}