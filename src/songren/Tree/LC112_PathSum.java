package songren.Tree;

import java.util.Stack;

/**
 * Created by yesongren on 2020/3/29
 * 112. Path Sum
 */
public class LC112_PathSum {
    // Time: O(n), Space: O(n)
    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSumRecursive(root.left, sum - root.val) ||
                hasPathSumRecursive(root.right, sum - root.val);
    }

    // Time: O(n), Space: O(n)
    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(sum);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            int s = sumStack.pop();
            if (n.left == null && n.right == null && n.val == s) return true;
            if (n.left != null) {
                stack.push(n.left);
                sumStack.push(s - n.val);
            }
            if (n.right != null) {
                stack.push(n.right);
                sumStack.push(s - n.val);
            }
        }
        return false;
    }
}
