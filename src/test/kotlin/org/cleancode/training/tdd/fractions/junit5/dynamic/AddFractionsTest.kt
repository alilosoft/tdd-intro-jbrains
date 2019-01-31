package org.cleancode.training.tdd.fractions.junit5.dynamic

import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class AddFractionsTest {

    private fun addFractionsDynamicTest(input: List<Fraction>, result: Fraction): DynamicTest =
            dynamicTest("${input.joinToString(" + ")} should be: $result") {
                assertEquals(result, input.fold(Fraction(0), Fraction::add))
            }

    private val testData = mapOf(
            listOf(Fraction(0), Fraction(0)) to Fraction(0),
            listOf(Fraction(1), Fraction(2)) to Fraction(3),
            listOf(Fraction(1), Fraction(2), Fraction(3)) to Fraction(6),
            listOf(2 over 7, 3 over 7) to (5 over 7),
            listOf(2 over 7, 3 over 7, 4 over 7) to (9 over 7)
    )

    private val wholeNumberTestData = testData.filter { input -> input.key.all { it.denominator == 1 } }

    @TestFactory
    fun `Adding Whole Number Fractions`() = wholeNumberTestData.map { (input, result) -> addFractionsDynamicTest(input, result) }

    private val sameDenominatorTestData = testData.filter { input -> input.key.all { it.denominator != 1 } }

    @TestFactory
    fun `Adding Fractions With Same Denominators`() = sameDenominatorTestData.map { (input, result) -> addFractionsDynamicTest(input, result) }

    private val addingAndReducingTestData = listOf(
            listOf(4 over 7, 3 over 7) to Fraction(1),
            listOf(3 over 6, 2 over 9) to (13 over 18)
    )

    @TestFactory // create test factory using method reference
    fun `Adding & Reducing Result`() = addingAndReducingTestData.map(::addFractionsDynamicTest)

    private fun addFractionsDynamicTest(cases: Pair<List<Fraction>, Fraction>): DynamicTest {
        val (input, result) = cases
        return dynamicTest("${input.joinToString(" + ")} = $result") {
            assertEquals(result, input.fold(Fraction(0), Fraction::add))
        }
    }
}