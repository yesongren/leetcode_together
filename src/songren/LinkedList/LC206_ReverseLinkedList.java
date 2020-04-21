package songren.LinkedList;

/**
 * Created by yesongren on 2020/4/21
 * 206. Reverse Linked List
 */
public class LC206_ReverseLinkedList {
    public ListNode reverseListIter(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
