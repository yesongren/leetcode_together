package category.JianZhiOffer.songren;

import java.awt.desktop.QuitResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yesongren on 2020/5/8
 * 面试题32 - II. 从上到下打印二叉树 II
 */
public class JZ32_2_LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelElem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelElem.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(levelElem);
        }
        return res;
    }
}
