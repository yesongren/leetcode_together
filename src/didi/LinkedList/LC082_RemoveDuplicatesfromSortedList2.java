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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode dummy = result;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) head = head.next;
                dummy.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                dummy = dummy.next;
            }
        }

        return result.next;
    }
}