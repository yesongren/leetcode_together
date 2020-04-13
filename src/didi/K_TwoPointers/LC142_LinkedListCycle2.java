package src.didi.K_TwoPointers;

public class LC142_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return fast;
            }
        }

        return null;
    }
}
