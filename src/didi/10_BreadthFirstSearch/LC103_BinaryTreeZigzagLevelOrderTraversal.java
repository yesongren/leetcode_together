package didi.bfs;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);

        int level = 1;

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                if (level % 2 == 0)
                    subList.add(0, curr.val);
                else
                    subList.add(curr.val);
            }
            result.add(subList);

            level++;
        }

        return result;
    }
}