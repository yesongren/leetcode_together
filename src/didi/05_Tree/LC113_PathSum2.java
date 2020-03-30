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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findSum(root, res, path, sum);
        return res;
    }

    private void findSum(TreeNode root, List<List<Integer>> res, List<Integer> path, int sum) {
        if (root == null) return;

        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        findSum(root.left, res, path, sum);
        findSum(root.right, res, path, sum);
        path.remove(path.size() - 1);
    }
}