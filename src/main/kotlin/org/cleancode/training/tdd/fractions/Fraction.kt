package org.cleancode.training.tdd.fractions

data class Fraction(val numerator: Int, val denominator: Int = 1) {

    fun add(other: Fraction): Fraction {
        val numerator = this.numerator + other.numerator
        val denominator = this.denominator
        return Fraction(numerator, denominator)
    }

}
