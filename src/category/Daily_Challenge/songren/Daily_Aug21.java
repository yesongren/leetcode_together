package category.Daily_Challenge.songren;

import category.Daily_Challenge.songren.util.TreeNode;

/**
 * Created by yesongren on 2020/8/21
 * 111. 二叉树的最小深度
 */
public class Daily_Aug21 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else if (root.left == null || root.right == null) return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
