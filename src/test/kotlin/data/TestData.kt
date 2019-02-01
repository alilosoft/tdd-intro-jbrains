@file:JvmName("TestData")

package data

import org.cleancode.training.tdd.fractions.Fraction
import org.junit.jupiter.params.provider.Arguments

fun reducableFractions() = arrayOf(
        Arguments.arguments(2, 4, Fraction(1, 2)),
        Arguments.arguments(9, 15, Fraction(3, 5)),
        Arguments.arguments(100, 100, Fraction(1))
)