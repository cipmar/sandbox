package org.example.twopointers;

import static java.lang.Math.abs;

public class TwoPointers {

    public static void main(String[] args) {

        TwoPointers twoPointers = new TwoPointers();
        int[] array = new int[]{1, 2, 3};
        int sum = 2;
        twoPointers.findSumInSortedArray(array, sum);

        char[] c = "hello".toCharArray();
        twoPointers.reverseString(c);
        System.out.println(c);
    }

    /**
     * Given a sorted array of unique integers and a target integer, return true if there exists a pair of numbers
     * that sum to target, false otherwise.
     */
    public boolean findSumInSortedArray(int[] array, int sum) {
        assert assertArraySorted(array);

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int crt = array[left] + array[right];

            if (crt == sum) {
                return true;
            }

            if (crt > sum) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    /**
     * Given two sorted integer arrays a and b, return a new array that combines both of them and is also sorted.
     */
    public int[] combineSortedArrays(int[] a, int[] b) {

        assert assertArraySorted(a);
        assert assertArraySorted(b);

        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                result[i + j] = a[i];
                i++;
            } else {
                result[i + j] = b[j];
                j++;
            }
        }

        while (i < a.length) {
            result[i + j] = a[i];
            i++;
        }

        while (j < b.length) {
            result[i + j] = b[j];
            j++;
        }

        return result;
    }

    /**
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     * <p>
     * A subsequence of a string is a sequence of characters that can be obtained by deleting some (or none) of the
     * characters from the original string, while maintaining the relative order of the remaining characters.
     * For example, "ace" is a subsequence of "abcde" while "aec" is not.
     */
    public boolean isSubsequence(String s, String t) {

        int i = 0; // pointer in string s

        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            if (i == s.length()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Reverse the characters of the given string.
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    /**
     * Checks if the given string is a palindrome.
     */
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
     * sorted in non-decreasing order.
     */
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int square;

            if (abs(nums[left]) > abs(nums[right])) {
                square = nums[left];
                left++;
            } else {
                square = nums[right];
                right--;
            }

            result[i] = square * square;
        }

        return result;
    }

    private boolean assertArraySorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
