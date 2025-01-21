package org.example.hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CountingTest {
    private final Counting counting = new Counting();

    @Test
    public void testIntersectionOfMultipleArrays() {

        int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};

        var response = counting.intersectionOfMultipleArrays(nums);

        Integer[] responseArray = response.toArray(new Integer[]{});
        assertArrayEquals(new Integer[]{3, 4}, responseArray);
    }

    @Test
    public void testFindLongestSubstring() {

        String str = "eceba";
        int k = 2;

        int response = counting.findLongestSubstring(str, k);

        assertEquals(3, response);
    }

    @Test
    public void testCountingElements() {

        int[] nums = {1, 2, 4, 5, 7, 9};

        int response = counting.countElements(nums);

        assertEquals(2, response);
    }

    @Test
    public void testMissingNumber() {

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        int response = counting.missingNumber(nums);

        assertEquals(8, response);
    }

}