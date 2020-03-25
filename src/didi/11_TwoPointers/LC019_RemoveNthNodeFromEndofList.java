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
    // one pinter
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return new ListNode(0);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;

        int len = 0;

        while(first != null) {
            len++;
            first = first.next;
        }

        int remain = len - n;
        int step = 0;

        first = dummy;

        while(remain > 0) {
            remain--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }
    // two pointers (distance n-1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return new ListNode(0);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // move first 3 steps ahead no need to keep two while loop (step < 3 first != null)

        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        while(first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}