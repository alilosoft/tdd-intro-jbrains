package org.cleancode.training.tdd.fractions

import kotlin.math.abs

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) abs(a) else gcd(b, a % b)
}