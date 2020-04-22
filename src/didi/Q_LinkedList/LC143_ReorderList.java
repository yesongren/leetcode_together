package src.didi.Q_LinkedList;

public class LC143_ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode head2 = reverse(findMid(head));
        merge(head, head2);
    }

    private ListNode findMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half = slow.next;
        slow.next = null;

        return half;
    }

    private ListNode reverse (ListNode head) {
        ListNode res = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }

        return res;
    }

    private void merge (ListNode left, ListNode right) {
        ListNode curr1 = left;
        ListNode curr2 = right;

        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }
}
