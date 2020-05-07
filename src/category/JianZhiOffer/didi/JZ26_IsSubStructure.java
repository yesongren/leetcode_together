package src.category.JianZhiOffer.didi;

import java.util.LinkedList;
import java.util.Queue;

public class JZ26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return helper(A.left, B.left) && helper(A.right, B.right);
    }

    public boolean isSubStructureBFS(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;

        boolean res = false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(A);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                assert curr != null;
                if (curr.val == B.val) {
                    res = true;
                    Queue<TreeNode> b = new LinkedList<>();
                    Queue<TreeNode> a = new LinkedList<>();
                    if (curr.left != null) a.offer(curr.left);
                    if (curr.right != null) a.offer(curr.right);
                    if (B.left != null) b.offer(B.left);
                    if (B.right != null) b.offer(B.right);
                    while (!b.isEmpty() && res) {
                        int bSize= b.size();
                        for (int j = 0; j < bSize; j++ ) {
                            TreeNode bcurr = b.poll();
                            TreeNode acurr = a.poll();
                            assert bcurr != null;
                            if (acurr != null && bcurr.val == acurr.val) {
                                if (bcurr.left != null) b.offer(bcurr.left);
                                if (bcurr.right != null) b.offer(bcurr.right);
                                if (acurr.left != null) a.offer(acurr.left);
                                if (acurr.right != null) a.offer(acurr.right);
                            } else {
                                res = false;
                                break;
                            }
                        }
                    }
                }
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return res;
    }
}
