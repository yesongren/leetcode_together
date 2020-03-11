package songren.LinkedList;

/**
 * Created by yesongren on 2020/3/11
 * 21. Merge Two Sorted Lists
 */
class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        val = x;
    }
}

public class LC021_MergeTwoSortedLists {
    // trivial
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int val2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return root.next;
    }

    // recursive
    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
