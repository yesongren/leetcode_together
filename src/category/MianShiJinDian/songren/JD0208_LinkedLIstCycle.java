package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/22
 * 面试题 02.08. 环路检测
 */
public class JD0208_LinkedLIstCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null; // essential
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) { // Only one condition will lead to NullPointerException
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
