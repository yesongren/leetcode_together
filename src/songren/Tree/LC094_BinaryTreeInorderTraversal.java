package songren.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yesongren on 2020/2/27
 * 94. Binary Tree Inorder Traversal
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
public class LC094_BinaryTreeInorderTraversal {

    // iteration
    public List<Integer> inorderTraversal_iteration(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = root.right;
            }
        }
        return res;
    }

    // recursive
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) helper(root.left, res);
            res.add(root.val);
            if (root.right != null) helper(root.right, res);
        }
    }
}
