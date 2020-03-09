package songren.Sort;

/**
 * Created by yesongren on 2020/3/9
 * 148. Sort List
 */
public class LC148_SortList {
    private void swap(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) return;
        int pivot = head.val;
        ListNode slow = head, fast = head.next;
        while (fast != end) {
            if (fast.val <= pivot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, end);
    }

    // Time: O(n*log(n)), Space: O(n)
    public ListNode quickSortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
}
