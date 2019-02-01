package org.cleancode.training.tdd.fractions

import kotlin.math.abs

fun gcdOf(a: Int, b: Int): Int {
    return if (b == 0) abs(a) else gcdOf(b, a % b)
}