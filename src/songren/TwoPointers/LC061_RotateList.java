package songren.TwoPointers;

/**
 * Created by yesongren on 2020/3/6
 * 61. Rotate List
 */
public class LC061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        //if (k == 0) return head;
        tail.next = head;
        ListNode newTail = tail;
        int stepsToNewHead = len - k;
        while(stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        ListNode newHead;
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
