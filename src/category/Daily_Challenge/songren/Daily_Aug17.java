package category.Daily_Challenge.songren;

import category.Daily_Challenge.songren.util.TreeNode;

/**
 * Created by yesongren on 2020/8/17
 * 110. 平衡二叉树
 */
public class Daily_Aug17 {
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }
}
