package category.Daily_Challenge.songren;

import category.Daily_Challenge.songren.util.TreeNode;

/**
 * Created by yesongren on 2020/8/8
 * 99. 恢复二叉搜索树
 */

public class Daily_Aug08 {
    TreeNode first = null, second = null, pre = null;

    public void recoverTree(TreeNode root) {
        findWrongNodes(root);
        swap(first, second);
    }

    public void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        if (pre != null && pre.val > root.val) {
            second = root;
            if (first == null) first = pre;
            else return;
        }
        pre = root;
        findWrongNodes(root.right);
    }

    public void swap(TreeNode n1, TreeNode n2) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
