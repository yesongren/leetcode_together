package didi.math;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode a = l1, b = l2, curr = dummy;
        int carry = 0;

        while(a != null || b != null){
            if (a == null) a = new ListNode(0);
            if (b == null) b = new ListNode(0);

            int sum = a.val + b.val + carry; // use .val
            carry = (sum > 9)? sum / 10 : 0;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            a = a.next;
            b = b.next;
        }

        if (carry > 0 ){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}