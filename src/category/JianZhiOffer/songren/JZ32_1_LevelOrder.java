package category.JianZhiOffer.songren;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yesongren on 2020/5/7
 * 面试题32 - I. 从上到下打印二叉树
 */
public class JZ32_1_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[] {};
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

