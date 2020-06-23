package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/24
 * 面试题 04.06. 后继者
 */
public class JD0406_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (p.val >= root.val) {
            TreeNode right = inorderSuccessor(root.right, p);
            return right;
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}
