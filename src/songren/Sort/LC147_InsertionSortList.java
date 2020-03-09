package songren.Sort;

/**
 * Created by yesongren on 2020/3/9
 * 147. Insertion Sort List
 */
class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        val = x;
    }
}

public class LC147_InsertionSortList {
    public ListNode insertionSortListFast(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy;
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            if (p.next != null && cur.val < p.next.val) p = dummy;
            while (p.next != null && cur.val >= p.next.val)
                p = p.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
