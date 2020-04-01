package src.didi.G_DepthFirstSearch;

public class LC129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int prev) {
        if (root == null) return 0;
        int tmp = prev * 10 + root.val;
        if (root.left == null && root.right == null) return tmp;
        return helper(root.left, tmp) + helper(root.right, tmp);
    }
}
