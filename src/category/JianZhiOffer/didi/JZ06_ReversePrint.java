package src.category.JianZhiOffer.didi;

public class JZ06_ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            count++;
        }

        int[] res = new int[count];
        int i = 0;

        while (pre != null) {
            res[i++] = pre.val;
            pre = pre.next;
        }

        return res;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }