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
    // preorder start = root;
    // inorder key from preorder left is left tree vice versa

    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    private TreeNode myTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        root.left = myTree(preorder, prestart + 1, prestart + position - instart, inorder, instart, position - 1);
        root.right = myTree(preorder, preend + position - inend + 1, preend, inorder, position + 1, inend);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;

        return myTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}