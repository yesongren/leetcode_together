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
        ListNode dummy = result;

        while (head != null) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            dummy.next = head;
            head = head.next;
            dummy = dummy.next;
        }

        return result.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();

        ListNode result = new ListNode(0);
        ListNode dummy = result;

        while (head != null) {
            if (!map.containsKey(head.val)) map.put(head.val, 1);
            else {
                int a = map.get(head.val) + 1;
                map.put(head.val, a);
            }
            if (map.get(head.val) == 1) {
                dummy.next = head;
                ListNode nextHead = head.next;
                head.next = null;
                dummy = dummy.next;
                head = nextHead;
            } else {
                head = head.next;
            }
        }

        return result.next;
    }
}