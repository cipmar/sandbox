package org.example.interviews;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Interview1 {

    public static int multiply(int a, int b) {

        int result = 0;
        for (int i = 0; i < Math.abs(a); i++) {
            result += b;
        }

        return result * (int) Math.signum(a) * (int) Math.signum(b);
    }

    public static int multiplyRec(int a, int b) {

        if (a == 0) {
            return 0;
        }

        return b + multiplyRec(a - 1, b);
    }

    public static List<Integer> findTopKFrequent(int[] array, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (var e : array) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));

        return list
                .subList(0, k)
                .stream()
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public static int[] findTopFrequentUsingMinHeap(int[] array, int k) {

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
