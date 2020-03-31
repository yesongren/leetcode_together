package songren.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/4/1
 * 109. Convert Sorted List to Binary Search Tree
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LC109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, lo, mid - 1);
        root.right = helper(list, mid + 1, hi);
        return root;
    }
}
