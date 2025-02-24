package org.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestPalindromeTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testFind(String s, String expected) {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String actual = longestPalindrome.find(s);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("cabcacbadrt", "abcacba"),
                Arguments.of("ccbcacbadrt", "bcacb"),
                Arguments.of("bcacbadrt", "bcacb"),
                Arguments.of("xxxbcacb", "bcacb"),
                Arguments.of("zbcaacbty", "bcaacb")
        );
    }
}