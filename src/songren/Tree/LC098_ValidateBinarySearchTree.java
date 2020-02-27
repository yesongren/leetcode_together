package songren.Tree;

import java.util.Stack;

/**
 * Created by yesongren on 2020/2/28
 * 98. Validate Binary Search Tree
 */
public class LC098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
