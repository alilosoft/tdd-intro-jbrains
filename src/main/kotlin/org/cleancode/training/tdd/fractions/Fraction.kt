package org.cleancode.training.tdd.fractions

data class Fraction(val numerator: Int, val denominator: Int = 1) {

    fun add(other: Fraction): Fraction {
        var rNumerator = 0
        var rDenominator = 0

        if (this.denominator == other.denominator) {
            rNumerator = this.numerator + other.numerator
            rDenominator = this.denominator
        } else {
            // calc common denominator
            rNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            rDenominator = this.denominator * other.denominator
        }
        return Fraction(rNumerator, rDenominator)
    }

}
