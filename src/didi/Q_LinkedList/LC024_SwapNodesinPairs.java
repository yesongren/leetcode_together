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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode result = new ListNode(0);
        ListNode dummy = result;

        while (head != null) {
            ListNode tmp = head.next;
            if (head.next == null) break;
            ListNode nexthead = head.next.next;
            head.next.next = null;
            head.next = null;
            dummy.next = tmp;
            dummy.next.next = head;
            dummy = dummy.next.next;
            head = nexthead;
        }

        if (head != null) dummy.next = head;

        return result.next;
    }
}