package org.example.heaps;

import java.util.PriorityQueue;

import static java.util.Comparator.reverseOrder;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone. On each turn, we choose the
 * heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y
 * with x <= y. If x == y, then both stones are destroyed. If x != y, then x is destroyed and y loses x weight.
 * Return the weight of the last remaining stone, or 0 if there are no stones left.
 */
public class Stones {

    public int lastStoneWeight(int[] stones) {
        var maxHeap = new PriorityQueue<Integer>(reverseOrder());

        for (var stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.remove();
            int second = maxHeap.remove();
            System.out.printf("%d smashed into %d and remained %d\n", first, second, first - second);
            maxHeap.add(first - second);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }

    public static void main(String[] args) {

        Stones stones = new Stones();
        int response = stones.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(response);
    }
}