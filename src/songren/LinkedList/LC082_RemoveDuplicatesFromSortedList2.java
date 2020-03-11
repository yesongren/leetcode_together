package songren.LinkedList;

/**
 * Created by yesongren on 2020/3/11
 * 82. Remove Duplicates from Sorted List II
 */
public class LC082_RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                do {
                    fast = fast.next;
                } while (fast.next != null && fast.val == fast.next.val);
                slow.next = fast.next;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }
}
