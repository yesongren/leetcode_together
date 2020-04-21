package songren.LinkedList;

/**
 * Created by yesongren on 2020/4/21
 * 92. Reverse Linked List II
 */
public class LC092_ReverseLinkedList2 {
    private ListNode successor = null;

    private ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
