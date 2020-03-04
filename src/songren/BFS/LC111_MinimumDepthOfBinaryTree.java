package songren.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yesongren on 2020/3/4
 * 111. Minimum Depth of Binary Tree
 *
 * recursive & Iterative
 */
public class LC111_MinimumDepthOfBinaryTree {
    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepthRecursive(root.right) + 1;
        if (root.right == null) return minDepthRecursive(root.left) + 1;
        return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }
        return -1;
    }
}
