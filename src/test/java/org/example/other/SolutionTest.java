package org.example.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {
    private final StringTransform solution = new StringTransform();

    @ParameterizedTest
    @MethodSource("testCases")
    public void testStringTransform(String input, String expected) {

        String result = solution.transform(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("CBACD", "C"),
                Arguments.of("CABABD", ""),
                Arguments.of("ACBDACBD", "ACBDACBD")
        );
    }
}