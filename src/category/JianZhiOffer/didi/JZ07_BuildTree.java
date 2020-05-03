package src.category.JianZhiOffer.didi;

import java.util.HashMap;
import java.util.Map;

public class JZ07_BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return myTree(preorder, 0, preorder.length - 1, 0, map);
    }
    private TreeNode myTree(int[] preorder, int preStart, int preEnd, int inStart, Map<Integer, Integer> map) {
        if (preStart > preEnd) return null; // need null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int position = map.get(preorder[preStart]);

        root.left = myTree(preorder, preStart + 1, preStart + position - inStart, inStart, map);
        root.right = myTree(preorder, preStart + position - inStart + 1, preEnd, position + 1, map);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
