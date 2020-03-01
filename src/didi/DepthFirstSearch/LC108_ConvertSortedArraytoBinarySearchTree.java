package didi.dfs;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return BSTRecursive(nums, 0, nums.length - 1);
    }

    private TreeNode BSTRecursive(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode curr = new TreeNode(nums[mid]);

        curr.left = BSTRecursive(nums, left, mid - 1);
        curr.right = BSTRecursive(nums, mid + 1, right);

        return curr;
    }
}