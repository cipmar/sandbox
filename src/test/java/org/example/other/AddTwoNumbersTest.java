package org.example.other;

import static org.example.other.AddTwoNumbers.toListNode;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void addTwoNumbers(ListNode n1, ListNode n2, org.example.other.ListNode expected) {

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode actual = addTwoNumbers.addTwoNumbers(n1, n2);

        assertTrue(equal(actual, expected));
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(toListNode(new int[]{1, 3, 4, 2}), toListNode(new int[]{1, 3, 4, 2}), toListNode(new int[]{2, 6, 8, 4})),
                Arguments.of(toListNode(new int[]{5, 4, 5, 7}), toListNode(new int[]{9, 8, 8, 2, 9, 1}), toListNode(new int[]{4, 3, 4, 0, 0, 2}))
        );
    }

    private boolean equal(org.example.other.ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }
}