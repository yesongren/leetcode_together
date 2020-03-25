package didi.Tree;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        recursive(result, root);

        return result;
    }

    private void recursive(List<Integer> result, TreeNode root) {
        if (root == null) return;

        recursive(result, root.left);
        result.add(root.val);
        recursive(result, root.right);
    }

}