package songren.LinkedList;

/**
 * Created by yesongren on 2020/3/11
 * 83. Remove Duplicates from Sorted List
 */
public class LC083_RemoveDuplicatesFromSortedList {
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
                slow.next = fast;
                slow = fast; // slow pointer really move 1
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next; // slow pointer really move 2
            }
        }
        return dummy.next;
    }
}
