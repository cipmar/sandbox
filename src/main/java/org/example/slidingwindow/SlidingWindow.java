package org.example.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {

    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * Given a string s, find the length of the longest substring without duplicate characters.
     */
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            boolean duplicate = !set.add(c);

            if (duplicate) {
                // remove from left until we find a char equals to c
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left++));
                }
                left++;
            } else {
                // we have a solution, check if it's longer than previous solution
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
            }
        }

        return max;
    }

    /**
     * Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum
     * is less than or equal to k. This is the problem we have been talking about above. We will now formally solve it.
     */
    public int findLengthLongestArrayWithSumLessOrEqualToK(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];

            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     * <p/>
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     * Any answer with a calculation error less than 10-5 will be accepted.
     */
    public double findMaxAverageFixedWindow(int[] nums, int k) {
        double cur = 0.0;

        for (int i = 0; i < k; i++) {
            cur += nums[i];
        }

        double response = cur;

        for (int left = 1; left < nums.length - k + 1; left++) {
            cur -= nums[left - 1];
            cur += nums[left + k - 1];

            response = Math.max(response, cur);
        }

        return response / k;
    }

    /**
     * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can
     * flip at most k 0's.
     */
    public int findMaxFromBinaryArrayMostKZeros(int[] nums, int k) {
        int left = 0;
        int cur = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                cur++;
            }

            while (left < nums.length && cur > k) {
                if (nums[left] == 0) {
                    cur--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
