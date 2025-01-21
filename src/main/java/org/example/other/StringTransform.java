package org.example.other;

import java.util.Collection;
import java.util.Stack;

/**
 * A string S consisting of the letters A, B, C and D is given. The string can be transformed either by removing a letter A together with an adjacent letter B, or by removing a letter C together with an adjacent letter D.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public String solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns any string that:
 * <p>
 * can be obtained from S by repeatedly applying the described transformation, and
 * cannot be further transformed.
 * If at some point there is more than one possible way to transform the string, any of the valid transformations may be chosen.
 */
class StringTransform {

    public String transform(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char p = stack.peek();
                if (matches(p, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return toString(stack);
    }

    private boolean matches(char p, char c) {

        return (
                (p == 'A' && c == 'B') ||
                        (p == 'B' && c == 'A') ||
                        (p == 'C' && c == 'D') ||
                        (p == 'D' && c == 'C')
        );
    }

    private String toString(Collection<Character> chars) {

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }
}
