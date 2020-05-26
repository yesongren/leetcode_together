package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/26
 * 面试题55 - II. 平衡二叉树
 */
public class JZ55_2_IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    // Time: O(nlog(n)), Space: O(n)
    public boolean isBalancedTreeTopDown(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalancedTreeTopDown(root.left) && isBalancedTreeTopDown(root.right);
    }

    // Time: O(n), Space: O(n)
    public boolean isBalancedTreeBottomUp(TreeNode root) {
        return getHeightAndCheck(root) != -1;
    }

    int getHeightAndCheck(TreeNode root) {
        if (root == null) return 0;

        int left = getHeightAndCheck(root.left);
        if (left == -1) return -1;

        int right = getHeightAndCheck(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
