package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/26
 * 面试题 04.10. 检查子树
 */
public class JD0410_CheckSubTree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        if (t2 == null) return true;
        return isSame(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
