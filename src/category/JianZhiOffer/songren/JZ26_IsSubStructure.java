package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/7
 * 面试题26. 树的子结构
 */
public class JZ26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        if (A == null) return false;
        return isMatch(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isMatch(TreeNode subA, TreeNode B) {

        if (subA == null) return false;
        if (subA.val == B.val) {
            boolean res = true;
            if (B.left != null) {
                res = isMatch(subA.left, B.left);
            }
            if (B.right != null) {
                res = res && isMatch(subA.right, B.right);
            }
            return res;
        }
        return false;
    }
}
