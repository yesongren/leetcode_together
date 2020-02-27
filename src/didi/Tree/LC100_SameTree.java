package didi.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        else if (p != null && q == null) return false;

        Queue<TreeNode> Q = new LinkedList<>();
        Queue<TreeNode> P = new LinkedList<>();
        Q.offer(p);
        P.offer(q);

        while (!Q.isEmpty()) {
            TreeNode currQ = Q.poll();
            TreeNode currP = P.poll();
            if (! check(currQ, currP)) return false;
            if(currQ != null) {
                if(! check(currQ.left, currP.left)) return false;
                if(currQ.left != null){
                    Q.offer(currQ.left);
                    P.offer(currP.left);
                }
                if(! check(currQ.right, currP.right)) return false;
                if(currQ.right != null){
                    Q.offer(currQ.right);
                    P.offer(currP.right);
                }
            }

        }

        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;

        return true;
    }
}