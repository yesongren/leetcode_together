package songren.BFS;

import java.util.*;

/**
 * Created by yesongren on 2020/3/4
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class LC103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Boolean flag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelElement = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelElement.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (flag) Collections.reverse(levelElement);
            res.add(levelElement);
            flag = !flag;
        }
        return res;
    }
}
