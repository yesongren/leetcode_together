package songren.TwoPointers;

/**
 * Created by yesongren on 2020/3/6
 * 19. Remove Nth Node From End of List
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class LC019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(n-- > 0) {
            fast = fast.next;
        }
        while(fast.next != null) {   //快慢指针要指向dummy， 否则这里会出现空指针异常
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
