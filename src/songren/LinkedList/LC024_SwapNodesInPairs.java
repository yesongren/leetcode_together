package songren.LinkedList;

/**
 * Created by yesongren on 2020/3/11
 * 24. Swap Nodes in Pairs
 */
public class LC024_SwapNodesInPairs {
    // recursive
    public ListNode swapPairsRec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode successor = head.next;
        head.next = swapPairsRec(successor.next);
        successor.next = head;
        return successor;
    }

    //non-recursive
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while(tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return dummy.next;
    }
}
