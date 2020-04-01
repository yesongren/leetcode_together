package src.didi.G_DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class LC109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode count = head;
        List<Integer> nums = new ArrayList<>();
        while(count != null) {
            nums.add(count.val);
            count = count.next;
        }

        return BSTRecursive(nums, 0, nums.size() - 1);
    }

    private TreeNode BSTRecursive(List<Integer> nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode curr = new TreeNode(nums.get(mid));

        curr.left = BSTRecursive(nums, left, mid - 1);
        curr.right = BSTRecursive(nums, mid + 1, right);

        return curr;
    }
}
