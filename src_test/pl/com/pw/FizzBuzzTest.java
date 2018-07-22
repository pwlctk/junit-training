import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.com.pw.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUpEach() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void shouldReturnBuzzMessageForNumber55() {
        // given

        // when
        String result = fizzBuzz.fizzBuzz(55);
        // then
        assertEquals("Buzz", result);
    }

    @Test
    void shouldReturnFizzMessageForNumber9() {
        // given

        // when
        String result = fizzBuzz.fizzBuzz(9);
        // then
        assertEquals("Fizz", result);
    }

    @Test
    void shouldReturnFizzBuzzMessageForNumber15() {
        // given

        // when
        String result = fizzBuzz.fizzBuzz(15);
        // then
        assertEquals("FizzBuzz", result);
    }

    @Test
    void shouldReturnNumber() {
        // given

        // when
        String result = fizzBuzz.fizzBuzz(4);
        // then
        assertEquals("4", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21})
    void shouldReturnFizzMessage(int number) {
        assertEquals("Fizz", fizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 35, 55})
    void shouldReturnBuzzMessage(int number) {
        assertEquals("Buzz", fizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75, 90})
    void shouldReturnFizzBuzzMessage(int number) {
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @CsvSource({"3, 10, 15", "6, 20, 30", "9, 25, 45"})
    void testWithCSVSource(int first, int second, int third) {
        assertEquals(fizzBuzz.fizzBuzz(first), "Fizz");
        assertEquals(fizzBuzz.fizzBuzz(second), "Buzz");
        assertEquals(fizzBuzz.fizzBuzz(third), "FizzBuzz");
    }
}
