package category.MianShiJinDian.songren;

import java.util.List;

/**
 * Created by yesongren on 2020/6/19
 * 面试题 02.01. 移除重复节点
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class JD0201_RemoveDuplicateNodes {
    // HashTable
    public ListNode removeDuplicateNodesHash(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int[] hash = new int[20001];
        while (cur != null) {
            if (hash[cur.val] > 0) {
                dummy.next = cur.next;
            } else {
                hash[cur.val]++;
                dummy = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    // Bubble Sort
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow;
            while(fast.next != null) {
                if (fast.next.val == slow.val) fast.next = fast.next.next;
                else fast = fast.next;
            }
            slow = slow.next;
        }
        return head;
    }
}
