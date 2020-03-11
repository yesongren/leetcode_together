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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode dummy = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode l1Tmp = l1.next;
                dummy.next = l1;
                l1.next = null;
                l1 = l1Tmp;
            } else {
                ListNode l2Tmp = l2.next;
                dummy.next = l2;
                l2.next = null;
                l2 = l2Tmp;
            }
            dummy = dummy.next;
        }

        if (l1 != null) dummy.next = l1;
        if (l2 != null) dummy.next = l2;

        return result.next;
    }
}