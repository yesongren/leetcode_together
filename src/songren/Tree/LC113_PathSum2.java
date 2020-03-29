package songren.Tree;

import java.util.*;

/**
 * Created by yesongren on 2020/3/29
 * 113. Path Sum II
 */
public class LC113_PathSum2 {
    private void path(TreeNode root, int sum, List<Integer> elem, List<List<Integer>> result) {
        if (root == null) return;
        elem.add(root.val);
        if (root.left == null && root.right == null && root.val == sum)
            result.add(new ArrayList<>(elem));
        path(root.left, sum - root.val, elem, result);
        path(root.right, sum - root.val, elem, result);
        elem.remove(elem.size() - 1); // T: O(1)
    }

    // Time: O(n), Space: O(n)
    public List<List<Integer>> pathSumRecursive(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        path(root, sum, elem, result);
        return result;
    }

    // Time: O(n), Space: O(n)
    public List<List<Integer>> pathSumIterative(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        int curSum = 0;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                elem.add(root.val);
                curSum += root.val;
                visited.add(root);
                stack.push(root);
                root = root.left;
            }
            TreeNode n = stack.peek();
            if (n.right == null || visited.contains(n.right)) {
                if (n.left == null && n.right == null && curSum == sum)
                    result.add(new ArrayList<>(elem));
                stack.pop();
                elem.remove(elem.size() - 1);
                curSum -= n.val;
                root = null;
            } else root = n.right;
        }
        return result;
    }

    // Time: O(n), Space: O(n)
    public List<List<Integer>> pathSumIterativePrev(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        int curSum = 0;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                elem.add(root.val);
                curSum += root.val;
                stack.push(root);
                root = root.left;
            }
            TreeNode n = stack.peek();
            if (n.right == null || n.right == prev) {
                if (n.left == null && n.right == null && curSum == sum)
                    result.add(new ArrayList<>(elem));
                stack.pop();
                elem.remove(elem.size() - 1);
                curSum -= n.val;
                prev = n;
                root = null;
            } else root = n.right;
        }
        return result;
    }
}
