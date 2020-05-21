package category.JianZhiOffer.songren;

import java.util.Stack;

/**
 * Created by yesongren on 2020/5/22
 * 面试题54. 二叉搜索树的第k大节点
 */
public class JZ54_KthLargestNode {
    public int kthLargest(TreeNode root, int k) {
        int cnt = 0;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                cnt++;
                if (cnt == k) return p.val;
                p = p.left;
            }
        }
        return 0;
    }
}
