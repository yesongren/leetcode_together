package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/23
 * 面试题 04.04. 检查平衡性
 */
public class JD0404_CheckBalance {
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int h = Math.max(left, right) + 1;
        return h;
    }

    public boolean isBalanced(TreeNode root) {
        // 要满足root左右子树高度差不超过1 && 左子树isBalanced && 右子树isBalanced
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }
}
