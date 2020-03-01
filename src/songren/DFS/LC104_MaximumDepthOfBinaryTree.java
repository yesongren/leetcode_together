package songren.DFS;

/**
 * Created by yesongren on 2020/3/1
 * 104. Maximum Depth of Binary Tree
 */
public class LC104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
