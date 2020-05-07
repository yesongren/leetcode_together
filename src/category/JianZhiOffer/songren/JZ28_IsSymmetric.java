package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/7
 * 面试题28. 对称的二叉树
 */
public class JZ28_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    private boolean helper (TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return (n1.val == n2.val) && helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }
}
