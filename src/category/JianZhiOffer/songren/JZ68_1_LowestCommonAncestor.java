package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/6/17
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 */
public class JZ68_1_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
