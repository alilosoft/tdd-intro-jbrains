package org.cleancode.training.tdd.fractions.junit5

import org.cleancode.training.tdd.fractions.Fraction
import org.cleancode.training.tdd.fractions.over
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class AddingFractionsTest {

    private fun addDynamicTest(input: List<Fraction>, result: Fraction): DynamicTest =
            dynamicTest("${input.joinToString(" + ")} = $result") {
                assertEquals(result, input.fold(Fraction(0), Fraction::add))
            }

    private val testData = listOf(
            listOf(Fraction(0), Fraction(0)) to Fraction(0),
            listOf(Fraction(1), Fraction(2)) to Fraction(3),
            listOf(Fraction(1), Fraction(2), Fraction(3)) to Fraction(6),
            listOf(2 over 7, 3 over 7) to (5 over 7),
            listOf(2 over 7, 3 over 7, 4 over 7) to (9 over 7)
    )

    private val wholeNumberTestData = testData.filter { it.first.all { fraction -> fraction.denominator == 1 } }

    @TestFactory
    fun `Adding Whole Number Fractions`() = wholeNumberTestData.map { (input, result) -> addDynamicTest(input, result) }

    private val sameDenominatorTestData = listOf(
            listOf(2 over 7, 3 over 7) to (5 over 7),
            listOf(2 over 7, 3 over 7, 4 over 7) to (9 over 7)
    )

    @TestFactory
    fun `Adding Fractions With Same Denominators`() = sameDenominatorTestData.map { (input, result) -> addDynamicTest(input, result) }

    private val addingAndReducingTestData = listOf(
            listOf(4 over 7, 3 over 7) to Fraction(1),
            listOf(3 over 6, 2 over 9) to (13 over 18)
    )

    @TestFactory // create test factory using method reference
    fun `Adding & Reducing Result`() = addingAndReducingTestData.map(::addDynamicTest)

    private fun addDynamicTest(cases: Pair<List<Fraction>, Fraction>): DynamicTest {
        val (input, result) = cases
        return dynamicTest("${input.joinToString(" + ")} = $result") {
            assertEquals(result, input.fold(Fraction(0), Fraction::add))
        }
    }
}