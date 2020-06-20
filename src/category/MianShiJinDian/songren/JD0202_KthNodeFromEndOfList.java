package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/20
 * 返回倒数第 k 个节点
 */
public class JD0202_KthNodeFromEndOfList {
    public int kthToLast(ListNode head, int k) {
        ListNode p = head, q = head;
        int len = 0;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        int steps = len - k + 1;
        while (steps-- > 0) {
            q = q.next;
        }
        return q.val;
    }
}
