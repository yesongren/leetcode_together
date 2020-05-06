package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/7
 * 面试题24. 反转链表
 */
public class JZ24_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
