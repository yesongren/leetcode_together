package src.category.JianZhiOffer.didi;

public class JZ55_2_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
