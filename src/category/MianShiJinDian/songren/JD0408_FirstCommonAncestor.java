package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/26
 * 面试题 04.08. 首个共同祖先
 */
public class JD0408_FirstCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        else return root;
    }
}
