package org.example.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Counting {

    /**
     * 1941. Check if All Characters Have Equal Number of Occurrences
     * Given a string s, return true if s is a good string, or false otherwise.
     * A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
     */
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characters.put(c, characters.getOrDefault(c, 0) + 1);
        }

        return characters.values().stream().distinct().count() == 1;
    }

    /**
     * Example 2: 2248. Intersection of Multiple Arrays
     * Given a 2D array nums that contains n arrays of distinct integers, return a sorted array containing all the numbers that appear in all n arrays.
     * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]], return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
     */
    public List<Integer> intersectionOfMultipleArrays(int[][] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (var arr : nums) {
            for (var e : arr) {
                map.put(e, map.getOrDefault(e, 0) + 1);
            }
        }

        List<Integer> response = new ArrayList<>();
        for (var key : map.keySet()) {
            if (map.get(key) == nums.length) {
                response.add(key);
            }
        }

        response.sort(Integer::compare);

        return response;
    }

    /**
     * Example 1: You are given a string s and an integer k. Find the length of the longest substring that contains at most k distinct characters.
     * For example, given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece".
     */
    public int findLongestSubstring(String str, int k) {

        int left = 0;
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char x = str.charAt(left++);

                map.put(x, map.getOrDefault(c, 0) - 1);
                if (map.get(x) == 0) {
                    map.remove(x);
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /**
     * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
     * If there are duplicates in arr, count them separately.
     */
    public int countElements(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (var e : nums) {
            set.add(e);
        }

        int count = 0;

        for (var e : nums) {
            if (set.contains(e + 1)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
     * that is missing from the array.
     */
    public int missingNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (var e : nums) {
            set.add(e);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }
}
