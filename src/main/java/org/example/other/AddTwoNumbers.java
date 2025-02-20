package org.example.other;

public class AddTwoNumbers {

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode l = null;

        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {

            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int val = a + b + carry;
            carry = val / 10;
            val = val % 10;

            ListNode newNode = new ListNode(val, null);

            if (l == null) {
                l = newNode;
                result = l;
            } else {
                l.next = newNode;
                l = newNode;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return result;
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
}
