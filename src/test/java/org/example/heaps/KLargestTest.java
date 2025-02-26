package org.example.heaps;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KLargestTest {
    private final KLargest kLargest = new KLargest();

    @Test
    public void testKLargest() {
        int[] nums = {1, 2, 3, 2, 5, 3, 7, 2, 9, 3};
        int k = 3;

        int response = kLargest.findKLargestInArray(nums, k);

        assertEquals(5, response);
    }

    @Test
    public void testTopKFrequent() {

        int[] nums = {1, 2, 3, 2, 5, 3, 7, 2, 9, 3};
        int k = 3;

        int[] response = kLargest.findTopKFrequentUsingMinHeap(nums, k);

        assertArrayEquals(new int[]{9, 3, 2}, response);
    }

    @Test
    public void testKSmallestDistinct() {
        int[] nums = {1, 2, 3, 2, 5, 3, 7, 2, 9, 3};
        int k = 3;

        int response = kLargest.findKSmallestDistinctInArray(nums, k);

        assertEquals(3, response);
    }
}