package category.JianZhiOffer.songren;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/6/17
 * 面试题68 - II. 二叉树的最近公共祖先
 */
public class JZ68_2_LowestCommonAncestor {
    private TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorRec(root.left, p, q);
        TreeNode right = lowestCommonAncestorRec(root.right, p, q);
        if (left == null && right == null) return null;
        else if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public TreeNode lowestCommonAncestorPath(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        List<TreeNode> qpath = new ArrayList<>();
        searchInTrees(root, p, ppath);
        searchInTrees(root, q, qpath);
        int len = Math.min(ppath.size(), qpath.size());
        int i = 0;
        while (i < len && ppath.get(i) == qpath.get(i)) {
            i++;
        }
        return ppath.get(i - 1);
    }

    public boolean searchInTrees(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean res = searchInTrees(root.left, node, path) || searchInTrees(root.right, node, path);
        if (res) return true;
        path.remove(path.size() - 1);
        return false;
    }
}
