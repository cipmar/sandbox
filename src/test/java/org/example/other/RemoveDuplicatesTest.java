package org.example.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveDuplicatesTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testRemoveDuplicates(String input, String expected) {

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        String actual = removeDuplicates.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abbaca", "ca"),
                Arguments.of("abccba", ""),
                Arguments.of("abcabc", "abcabc"),
                Arguments.of("abcdefcgijjigcfedcb", "a"),
                Arguments.of("", "")
        );
    }
}