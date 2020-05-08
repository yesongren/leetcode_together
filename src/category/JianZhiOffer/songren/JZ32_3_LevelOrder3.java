package category.JianZhiOffer.songren;

import java.util.*;

/**
 * Created by yesongren on 2020/5/8
 * 面试题32 - III. 从上到下打印二叉树 III
 */
public class JZ32_3_LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelElem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelElem.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (leftToRight) Collections.reverse(levelElem);
            res.add(levelElem);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
