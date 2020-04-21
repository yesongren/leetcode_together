package songren.LinkedList;

/**
 * Created by yesongren on 2020/4/21
 * 143. Reorder List
 */
public class LC143_ReorderList {

    private static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode preNode = null;
        ListNode curNode = slow;
        ListNode nextNode;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        ListNode list;
        list = new ListNode(Integer.MAX_VALUE);
        while(head != null && preNode != null){
            list.next = head;
            head = head.next;

            list.next.next = preNode;
            preNode = preNode.next;

            list = list.next.next;
        }
        if(preNode != null){
            list.next = preNode;
        }
    }
}
