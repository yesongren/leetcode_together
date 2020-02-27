package songren.Tree;

/**
 * Created by yesongren on 2020/2/28
 * 100. Same Tree
 */
public class LC100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
