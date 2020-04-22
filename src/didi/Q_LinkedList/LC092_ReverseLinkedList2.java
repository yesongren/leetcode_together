package src.didi.Q_LinkedList;

public class LC092_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int count = 0;
        ListNode pre = dummy;

        for (int i = 0; i < m - 1; i++)
            pre = pre.next;

        ListNode start = pre.next;
        ListNode end = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = end.next;
            end.next = pre.next;
            pre.next = end;
            end = start.next;
        }

        return dummy.next;
    }
}
