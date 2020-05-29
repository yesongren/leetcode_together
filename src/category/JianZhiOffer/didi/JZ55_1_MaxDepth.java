package src.category.JianZhiOffer.didi;

public class JZ55_1_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
