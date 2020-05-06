package src.category.JianZhiOffer.didi;

public class JZ22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int t = 0;

        while (fast != null) {
            if (t >= k)
                slow = slow.next;
            fast = fast.next;
            t++;
        }

        return slow;
    }
}
