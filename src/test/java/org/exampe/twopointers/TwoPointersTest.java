package org.exampe.twopointers;

import org.example.twopointers.TwoPointers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TwoPointersTest {

    private TwoPointers twoPointers;

    @BeforeEach
    public void setup() {
        twoPointers = new TwoPointers();
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 20, 12, 8, 14})
    public void testCase1(int sum) {
        int[] array = {1, 3, 5, 6, 8, 9, 11};

        boolean result = twoPointers.findSumInSortedArray(array, sum);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 1, 18, 22, 0})
    public void testCase2(int sum) {
        int[] array = {1, 3, 5, 6, 8, 9, 11};

        var result = twoPointers.findSumInSortedArray(array, sum);

        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hellolleh", "mamaamam", "a", "", "aba", "1234554321"})
    public void testCasePalindrome1(String s) {
        boolean result = twoPointers.isPalindrome(s);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "mama", "ab", "abcca"})
    public void testCasePalindrome2(String s) {
        boolean result = twoPointers.isPalindrome(s);
        assertFalse(result);
    }

    @Test
    public void testCaseCombine() {

        int[] a = {1, 3, 5};
        int[] b = {2, 4, 5, 6, 8, 9};

        int[] result = twoPointers.combineSortedArrays(a, b);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 5, 6, 8, 9}, result);
    }

    @Test
    public void testCaseIsSubsequence() {
        String s = "adf";
        String t = "abcdef";

        boolean result = twoPointers.isSubsequence(s, t);

        assertTrue(result);
    }

    @Test
    public void testCaseSortedSquares() {

        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = twoPointers.sortedSquares(nums);
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, result);
    }

    @Test
    public void testCaseSortedSquares2() {

        int[] nums = {-3, -2, -1};
        int[] result = twoPointers.sortedSquares(nums);
        assertArrayEquals(new int[]{1, 4, 9}, result);
    }
}
