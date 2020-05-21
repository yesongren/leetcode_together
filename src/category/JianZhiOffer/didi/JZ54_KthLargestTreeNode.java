package src.category.JianZhiOffer.didi;

import java.util.Stack;

public class JZ54_KthLargestTreeNode {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            TreeNode pop = stack.pop();
            count++;
            if (count == k) return pop.val;
            curr = pop.left;
        }

        return 0;
    }
}
