package src.category.JianZhiOffer.didi;

public class JZ24_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = res;
            res = curr;
            curr = next;
        }

        return res;
    }
}
