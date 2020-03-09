package didi.sort;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left;
        ListNode right;
        ListNode tail;

        for (int i = 1; i < len; i<<=1) {
            curr = dummy.next;
            tail = dummy;
            while (curr != null) {
                left = curr;
                right = split(left, i);
                curr = split(right, i);
                Pair<ListNode, ListNode> p = merge(left,right);
                tail.next = p.getKey();
                tail = p.getValue();
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        while (head.next != null && --step != 0) head = head.next;

        ListNode rest = head.next;
        head.next = null;

        return rest;
    }

    private Pair<ListNode, ListNode> merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        while (tail.next != null) tail = tail.next;

        return new Pair<ListNode, ListNode>(dummy.next, tail);
    }
}