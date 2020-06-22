package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/21
 * 面试题 02.06. 回文链表
 */
public class JD0206_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        return isEqual(head, reverse(head));
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode n = new ListNode(node.val);
            n.next = pre;
            pre = n;
            node = node.next;  //todo
        }
        return pre;
    }

    public boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
