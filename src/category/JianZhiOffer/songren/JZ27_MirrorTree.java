package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/7
 * 面试题27. 二叉树的镜像
 */
public class JZ27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        exchange(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    private void exchange(TreeNode root) {
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }
}
