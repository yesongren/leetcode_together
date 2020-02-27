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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();

        if (n == 0) return result;

        return Helper(1, n);
    }

    private List<TreeNode> Helper(int min, int max){
        List<TreeNode> result = new ArrayList<>();

        if (min > max) return result;

        for (int i = min; i <= max; i++) {
            List<TreeNode> leftList = Helper(min, i - 1);
            List<TreeNode> rightList = Helper(i + 1, max);

            if (leftList.size() == 0 && rightList.size() == 0) {
                result.add(new TreeNode(i));
            }
            else if (leftList.size() == 0) {
                for (TreeNode right : rightList){
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    result.add(root);
                }
            }
            else if (rightList.size() == 0) {
                for (TreeNode left : leftList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    result.add(root);
                }
            }
            else {
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}