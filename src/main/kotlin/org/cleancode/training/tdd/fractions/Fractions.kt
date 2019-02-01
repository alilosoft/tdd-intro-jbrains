package org.cleancode.training.tdd.fractions

const val DENOMINATOR_ZERO_ERROR = "Denominator can't be Zero"

data class Fraction(var numerator: Int, var denominator: Int = 1) {

    init {
        assert(denominator != 0) { DENOMINATOR_ZERO_ERROR }
        val gcd = gcdOf(numerator, denominator)
        val denominatorSign = if (denominator < 0) -1 else 1
        numerator /= gcd * denominatorSign
        denominator /= gcd * denominatorSign
    }

    fun add(other: Fraction): Fraction {
        val rNumerator = this.numerator * other.denominator + other.numerator * this.denominator
        val rDenominator = this.denominator * other.denominator
        return Fraction(rNumerator, rDenominator)
    }

    fun multiply(other: Fraction): Fraction {
        return Fraction(this.numerator * other.numerator, this.denominator * other.denominator)
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    companion object {
        @JvmStatic
        fun parse(source: String): Fraction {
            val errorMsg = "Can't parse $source to Fraction"
            assert(source.isNotEmpty()) { errorMsg }
            val sNumerator: String
            val sDenominator: String
            if (source.contains('/')) {
                val fractionParts = source.split("/")
                assert(fractionParts.size == 2) { errorMsg }
                sNumerator = fractionParts[0]
                sDenominator = fractionParts[1]
            } else {
                sNumerator = source
                sDenominator = "1"
            }
            try {
                val numerator = sNumerator.toInt()
                val denominator = sDenominator.toInt()
                return Fraction(numerator, denominator)
            } catch (e1: Exception) {
                throw NumberFormatException(errorMsg)
            }
        }
    }

}

infix fun Int.over(denominator: Int) = Fraction(this, denominator)

operator fun Fraction.plus(other: Fraction) = add(other)

operator fun Fraction.times(other: Fraction) = multiply(other)
