package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/5
 * 面试题18. 删除链表的节点
 */
public class JZ18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
        return dummy.next;
    }
}
