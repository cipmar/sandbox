package org.example.leetcode;

import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class Solution20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}
