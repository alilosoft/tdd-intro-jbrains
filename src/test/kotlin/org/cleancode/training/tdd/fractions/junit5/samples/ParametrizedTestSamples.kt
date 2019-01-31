package org.cleancode.training.tdd.fractions.junit5.samples

import org.assertj.core.api.Assertions.assertThat
import org.cleancode.training.tdd.fractions.junit5.NonStaticMethodSource
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Junit5 Parametrized Test Demo")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@NonStaticMethodSource
class ParametrizedTestSamples { // https://blog.codefx.org/libraries/junit-5-parameterized-tests/

    private var testCount = 0

    @BeforeEach
    fun beforeEachTest() {
        testCount++
        print("Test #$testCount.....")
    }

    @AfterEach
    fun afterEachTest() {
        println("Done!!!")
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(strings = ["foo", "bar"])
    fun `test isBlank() works as expected`(testedValue: String) {
        assertThat(testedValue).isNotBlank()
    }
}