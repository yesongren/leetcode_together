package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/7
 * 面试题22. 链表中倒数第k个节点
 */
public class JZ22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int steps = len - k - 1;
        while (steps-- >= 0) {
            head = head.next;
        }
        return head;
    }
}
