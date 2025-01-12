package org.example.binarysearch;

public class BinarySearch {

    boolean search(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = (right + left) / 2;
            if (array[mid] == target) {
                return true;
            }

            if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        boolean response = binarySearch.search(new int[]{1, 2, 3, 5, 7, 9, 11}, 3);
        System.out.println(response);

        response = binarySearch.search(new int[]{1, 2, 3, 5, 7, 9, 11}, 4);
        System.out.println(response);
    }
}
