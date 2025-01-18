package org.example.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KLargest {

    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     */
    int findKLargestInArray(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (var n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.peek();
    }

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * It is guaranteed that the answer is unique.
     */
    public int[] findTopKFrequentUsingMinHeap(int[] array, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (var e : array) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (var e : map.keySet()) {
            heap.add(e);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] response = new int[k];

        for (int i = 0; i < response.length; i++) {
            response[i] = heap.remove();
        }

        return response;
    }
}
