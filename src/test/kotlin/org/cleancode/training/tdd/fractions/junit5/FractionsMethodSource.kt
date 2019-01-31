package org.cleancode.training.tdd.fractions.junit5

import org.junit.jupiter.params.provider.MethodSource


@MethodSource("data.MethodSources#reducableFractions")
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class FractionsMethodSource