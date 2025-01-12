package org.example.prefixsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixSumTest {
    private final PrefixSum prefixSum = new PrefixSum();

    @Test
    public void testMinStartValue() {

        int[] nums = {-3, 2, -3, 4, 2};

        int response = prefixSum.minStartValue(nums);

        assertEquals(5, response);
    }

    @Test
    public void testMinStartValue2() {

        int[] nums = {1, 2};

        int response = prefixSum.minStartValue(nums);

        assertEquals(1, response);
    }

    @Test
    public void testCaseAnswerQueries1() {

        int[] nums = {1, 6, 3, 2, 7, 2};

        int[][] queries = {{0, 3}, {2, 5}, {2, 4}};

        int limit = 13;

        boolean[] response = prefixSum.answerQueries(nums, queries, limit);

        assertArrayEquals(new boolean[]{true, false, true}, response);
    }
}