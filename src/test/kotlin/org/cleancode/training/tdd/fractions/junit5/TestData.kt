@file:JvmName("TestData")

package org.cleancode.training.tdd.fractions.junit5

import org.cleancode.training.tdd.fractions.Fraction
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

fun reduceableFractions() = arrayOf(
        arguments(2, 4, Fraction(1, 2)),
        arguments(9, 15, Fraction(3, 5)),
        arguments(100, 100, Fraction(1))
)

@MethodSource("org.cleancode.training.tdd.fractions.junit5.TestData#reduceableFractions")
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ReduceableFractionsMethodSource