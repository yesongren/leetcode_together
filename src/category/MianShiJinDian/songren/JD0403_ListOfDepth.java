package category.MianShiJinDian.songren;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yesongren on 2020/6/23
 * 面试题 04.03. 特定深度节点链表
 */
public class JD0403_ListOfDepth {
    public ListNode[] listOfDepth(TreeNode root) {
        if (root == null) return null;
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ListNode node = new ListNode(0);
            ListNode head = node;
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.poll();
                ListNode n = new ListNode(t != null ? t.val : 0);
                node.next = n;
                node = n;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(head.next);
        }
        return res.toArray(new ListNode[0]);
    }
}
