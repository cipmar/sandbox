package org.example.other;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * <p>
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return toString(stack);
    }

    String toString(Stack<Character> chars) {

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }
}
