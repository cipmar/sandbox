package org.example.prefixsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PrefixSumTest {
    private final PrefixSum prefixSum = new PrefixSum();

    @Test
    public void testCaseAnswerQueries1() {

        int[] nums = new int[]{1, 6, 3, 2, 7, 2};

        int[][] queries = new int[][]{
                new int[]{0, 3},
                new int[]{2, 5},
                new int[]{2, 4}
        };

        int limit = 13;

        boolean[] response = prefixSum.answerQueries(nums, queries, limit);

        assertArrayEquals(new boolean[]{true, false, true}, response);
    }
}