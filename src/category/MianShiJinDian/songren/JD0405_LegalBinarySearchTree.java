package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/23
 * 面试题 04.05. 合法二叉搜索树
 */
public class JD0405_LegalBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long left, long right) {
        if (node == null) return true;
        if (node.val <= left || node.val >= right) return false;
        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}
