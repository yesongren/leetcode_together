package src.category.JianZhiOffer.didi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ32_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                assert curr != null;
                res.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}
