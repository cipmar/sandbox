package org.example.prefixsum;

import java.util.Arrays;

public class PrefixSum {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 6, 3, 2, 7, 2};

        int[][] queries = new int[][]{
                new int[]{0, 3},
                new int[]{2, 5},
                new int[]{2, 4}
        };

        int limit = 13;

        System.out.println(Arrays.toString(new PrefixSum().answerQueries(nums, queries, limit)));
    }

    /**
     * Given an array of integers nums, you start with an initial positive value startValue.
     * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
     * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
     */
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minValue = 1;

        for (int num : nums) {
            sum += num;
            minValue = Math.max(minValue, -sum + 1);
        }

        return minValue;
    }

    /**
     * Given an integer array nums, an array queries where queries[i] = [x, y] and an integer limit, return a boolean
     * array that represents the answer to each query. A query is true if the sum of the subarray from x to y is less
     * than limit, or false otherwise.
     * For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and limit = 13, the answer is
     * [true, false, true]. For each query, the subarray sums are [12, 14, 12].
     */
    public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {

        int[] prefixes = new int[nums.length];
        prefixes[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixes[i] = prefixes[i - 1] + nums[i];
        }

        boolean[] response = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int sum = prefixes[queries[i][1]] - prefixes[queries[i][0]] + nums[queries[i][0]];
            response[i] = sum < limit;
        }

        return response;
    }

    /**
     * Given an integer array nums, find the number of ways to split the array into two parts so that the first section
     * has a sum greater than or equal to the sum of the second section. The second section should have at least one number.
     */
    public int findNumberOfSplitArray(int[] nums) {

        int[] prefixes = new int[nums.length];

        prefixes[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixes[i] = prefixes[i - 1] + nums[i];
        }

        int response = 0;

        for (int i = 0; i < nums.length; i++) {

            int leftSection = prefixes[i];
            int rightSection = prefixes[nums.length - 1] - prefixes[i];

            if (leftSection >= rightSection) {
                response++;
            }
        }

        return response;
    }
}
