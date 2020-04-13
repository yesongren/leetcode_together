package songren.TwoPointers;

/**
 * Created by yesongren on 2020/4/13
 * 141. Linked List Cycle
 */
public class LC141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
