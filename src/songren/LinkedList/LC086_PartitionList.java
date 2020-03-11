package songren.LinkedList;

/**
 * Created by yesongren on 2020/3/11
 * 86. Partition List
 */
public class LC086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(0);
        ListNode maxHead = new ListNode(0);
        ListNode minPointer = minHead;
        ListNode maxPointer = maxHead;

        while (head != null) {
            if (head.val < x) {
                minPointer.next = head;
                minPointer = head;
            } else {
                maxPointer.next = head;
                maxPointer = head;
            }
            head = head.next;
            maxPointer.next = null;
            minPointer.next = maxHead.next;
        }
        return minHead.next;
    }
}
