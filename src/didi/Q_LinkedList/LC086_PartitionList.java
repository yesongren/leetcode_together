package didi.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode less = new ListNode(0);
        ListNode result = less;
        ListNode great = new ListNode(0);
        ListNode half = great;

        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                ListNode newHead = curr.next;
                curr.next = null;
                curr = newHead;
                less = less.next;
            } else {
                great.next = curr;
                ListNode newHead = curr.next;
                curr.next = null;
                curr = newHead;
                great = great.next;
            }
        }

        less.next = half.next;

        return result.next;
    }
}