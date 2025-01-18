package org.example.mambu;

import java.util.*;

public class GroupAnagramWords {

    public static List<List<String>> groupAnagrams(List<String> words) {

        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (var word : words) {
            Map<Character, Integer> wordAsMap = wordToMap(word);

            List<String> anagramsOfWord = map.putIfAbsent(wordAsMap, new ArrayList<>() {{
                add(word);
            }});

            if (anagramsOfWord != null) {
                anagramsOfWord.add(word);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static Map<Character, Integer> wordToMap(String word) {

        Map<Character, Integer> map = new HashMap<>();

        for (var c : word.toCharArray()) {
            Integer value = map.putIfAbsent(c, 0);
            if (value != null) {
                map.put(c, value + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Collection<List<String>> lists = groupAnagrams(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        System.out.println(lists);

        lists = groupAnagrams(Arrays.asList());
        System.out.println(lists);
    }
}
