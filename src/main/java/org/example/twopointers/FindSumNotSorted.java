package org.example.twopointers;

import java.util.HashSet;

public class FindSumNotSorted {

    public static void main(String[] args) {

        FindSumNotSorted findSumNotSorted = new FindSumNotSorted();
        int[] array = new int[]{7, 2, 3, 1, 2, 5, 6, 2, 4};
        int sum = 11;
        var result = findSumNotSorted.find(array, sum);
        System.out.println(result);
    }

    public boolean find(int[] array, int sum) {

        HashSet<Integer> complements = new HashSet<>();
        complements.add(array[0]);

        for (int i = 1; i < array.length; i++) {

            int complement = sum - array[i];
            if (complements.contains(complement)) {
                return true;
            } else {
                complements.add(array[i]);
            }
        }

        return false;
    }
}
