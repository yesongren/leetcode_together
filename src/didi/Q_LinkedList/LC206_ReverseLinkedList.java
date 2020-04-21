package src.didi.Q_LinkedList;

public class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
