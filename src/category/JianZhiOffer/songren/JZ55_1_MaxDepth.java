package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/26
 * 面试题55 - I. 二叉树的深度
 */
public class JZ55_1_MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
