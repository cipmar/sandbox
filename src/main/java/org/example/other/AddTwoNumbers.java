package org.example.other;

import java.util.StringJoiner;

public class AddTwoNumbers {

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode l = null;

        int x = 0;

        while (l1 != null || l2 != null || x > 0) {

            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int val = a + b + x;
            x = val / 10;
            val = val % 10;

            ListNode crt = new ListNode(val, null);
            if (l == null) {
                l = crt;
                result = l;
            } else {
                l.next = crt;
                l = crt;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return result;
    }

    private static void printList(ListNode listNode) {
        StringJoiner stringJoiner = new StringJoiner(",");

        while (listNode != null) {
            stringJoiner.add(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
        System.out.println(stringJoiner);
    }

    static ListNode toListNode(int[] array) {

        ListNode l = null;
        ListNode result = null;

        for (int i : array) {
            ListNode crt = new ListNode(i);
            if (l == null) {
                l = crt;
                result = l;
            } else {
                l.next = crt;
                l = crt;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l1 = toListNode(new int[]{4, 2, 3, 2, 1});
        ListNode l2 = toListNode(new int[]{6, 2, 3, 2, 1, 1, 2, 3});
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        printList(result);
    }

}
