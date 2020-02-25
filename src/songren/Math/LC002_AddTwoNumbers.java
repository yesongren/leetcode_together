package songren.Math;

/**
 * Created by yesongren on 2020/2/25
 * 2. Add Two Numbers
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class LC002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
//            int val1 = l1 == null ? 0 : l1.val;
//            int val2 = l2 == null ? 0 : l2.val;
//            int sum = val1 + val2 + carry;
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            if(carry == 1) cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
