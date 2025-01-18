package org.example.interviews;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Interview1Test {

    private final Interview1 interview1 = new Interview1();

    public static Stream<Arguments> multiplicationTestCases() {
        return Stream.of(
                Arguments.of(10, 10, 100),
                Arguments.of(0, 10, 0),
                Arguments.of(10, 0, 0),
                Arguments.of(-10, -10, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplicationTestCases")
    public void testMultiplication(int a, int b, int result) {
        assertEquals(result, interview1.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("multiplicationTestCases")
    public void testMultiplicationRec(int a, int b, int result) {
        assertEquals(result, interview1.multiplyRec(a, b));
    }
}