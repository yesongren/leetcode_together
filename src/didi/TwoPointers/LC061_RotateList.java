package didi.twopointers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 0;

        ListNode first = head;

        while(first != null) {
            first = first.next;
            len++;
        }

        int shift = k % len;

        if (shift == 0) return head;

        first = head;

        for (int i = 0; i < len - shift - 1; i++) {
            first = first.next;
        }
        ListNode second = first.next;

        first.next = null;

        ListNode third = second;

        for (int i = 0; i < shift - 1; i++) {
            second = second.next;
        }

        second.next = head;

        return third;
    }
}