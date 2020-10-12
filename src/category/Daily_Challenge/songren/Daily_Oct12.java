package category.Daily_Challenge.songren;

import category.Daily_Challenge.songren.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/10/12
 * 530. 二叉搜索树的最小绝对差
 */
public class Daily_Oct12 {
    private List<Integer> res = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        int minres = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            minres = Math.min(minres, (res.get(i) - res.get(i - 1)));
        }
        return minres;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
