package org.example.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindrome {

    public String find(String s) {

        String max = "";

        for (int center = 0; center < s.length(); center++) {

            // check longest palindrome with center `center`
            String crt = getLongestPalindrome(s, center - 1, center + 1);

            if (crt.length() > max.length()) {
                max = crt;
            }

            // check longest palindrome with center `center`
            crt = getLongestPalindrome(s, center - 1, center);

            if (crt.length() > max.length()) {
                max = crt;
            }
        }

        return max;
    }

    private String getLongestPalindrome(String s, int left, int right) {
        String palindrome = right - left == 2 ? s.substring(left + 1, right) : "";

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindrome = s.substring(left, right + 1);
            left--;
            right++;
        }

        return palindrome;
    }
}
