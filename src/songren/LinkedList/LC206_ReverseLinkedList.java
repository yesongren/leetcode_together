package songren.LinkedList;

/**
 * Created by yesongren on 2020/4/21
 * 206. Reverse Linked List
 */
public class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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
}
