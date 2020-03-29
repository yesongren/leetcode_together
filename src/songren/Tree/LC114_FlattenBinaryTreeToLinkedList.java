package songren.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/3/29
 * 114. Flatten Binary Tree to Linked List
 */
public class LC114_FlattenBinaryTreeToLinkedList {
    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // Time: O(n), Space: O(n)
    public void flattenPreorder(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); ++i) {
            cur.left = null;
            cur.right = list.get(i);
            cur = cur.right;
        }
    }

    private TreeNode prev = null;

    // Time: O(n), Space: O(n)
    public void flattenReversePreorder(TreeNode root) {
        if (root == null) return;
        flattenReversePreorder(root.right);
        flattenReversePreorder(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
