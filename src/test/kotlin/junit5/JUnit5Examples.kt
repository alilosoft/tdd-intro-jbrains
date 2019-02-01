package junit5

import org.assertj.core.api.Assertions.assertThat
import org.cleancode.training.tdd.fractions.junit5.NonStaticMethodSource
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource


@DisplayName("Junit5 Parametrized Test Demo")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@NonStaticMethodSource
class JUnit5Examples { // https://blog.codefx.org/libraries/junit-5-parameterized-tests/

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
    fun `test isBlank() works as expected`(word: String) {
        assertThat(word).isNotBlank()
    }

    @ParameterizedTest(name = "[{0}] should not be blank")
    @MethodSource("wordsToCheck")
    fun checkNonBlankWords(word: String) {
        assertThat(word).isNotBlank()
    }

    fun wordsToCheck() = arrayOf("Hello", "JUnit5", "In Kotlin")

    @ParameterizedTest
    @CsvSource("Hello, 5", "JUnit 5, 7", "In Kotlin, 9")
    fun withCsvSource(word: String, length: Int) {
        assertThat(word.length).isEqualTo(length)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/words-lengths.csv"])
    fun checkWordsFromCsvFile(word: String, length: Int) {
        assertThat(word.length).isEqualTo(length)
    }
}