package src.category.JianZhiOffer.didi;

public class JZ27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    // not value but TreeNode
    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
