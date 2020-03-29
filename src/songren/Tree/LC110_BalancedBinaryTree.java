package songren.Tree;

/**
 * Created by yesongren on 2020/3/29
 * 110. Balanced Binary Tree
 */
public class LC110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftMax = getHeight(root.left);
        int rightMax = getHeight(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
