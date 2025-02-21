package org.exampe.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.example.slidingwindow.SlidingWindow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SlidingWindowTest {

    private SlidingWindow slidingWindow = new SlidingWindow();

    @ParameterizedTest
    @MethodSource("testCasesLengthOfLongestSubstring")
    public void testLengthOfLongestSubstring(String s, int expected) {

        int actual = slidingWindow.lengthOfLongestSubstring(s);

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testCasesLengthOfLongestSubstring() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("tmmzuxt", 5)
        );
    }

    @Test
    public void testFindLengthLongestArrayWithSumLessOrEqualToK() {

        // arrange
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};

        // actin
        int result = slidingWindow.findLengthLongestArrayWithSumLessOrEqualToK(nums, 8);

        // assert
        assertEquals(4, result);
    }

    @Test
    public void testFindLengthLongestArrayWithSumLessOrEqualToK2() {

        // arrange
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // actin
        int result = slidingWindow.findLengthLongestArrayWithSumLessOrEqualToK(nums, 10);

        // assert
        assertEquals(4, result);
    }

    @Test
    public void testCaseMaxAverage() {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double response = slidingWindow.findMaxAverageFixedWindow(nums, k);

        assertEquals(12.75, response);
    }

    @Test
    public void testCaseFindMaxFromBinaryArrayMostKZeros1() {

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int max = slidingWindow.findMaxFromBinaryArrayMostKZeros(nums, k);

        assertEquals(6, max);
    }

    @Test
    public void testCaseFindMaxFromBinaryArrayMostKZeros2() {

        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;

        int max = slidingWindow.findMaxFromBinaryArrayMostKZeros(nums, k);

        assertEquals(10, max);
    }
}
