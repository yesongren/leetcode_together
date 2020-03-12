package songren.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yesongren on 2020/2/28
 * 95. Unique Binary Search Trees II
 */
public class LC095_UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return genTreeList(1, n);
    }

    public List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) {
            ans.add(null);
        }
        // if (start == end) {
        //     ans.add(new TreeNode(start));
        //     return ans;
        // }
        for (int index = start; index <= end; index++) {
            List<TreeNode> leftTrees = genTreeList(start, index - 1);
            List<TreeNode> rightTrees = genTreeList(index + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(index);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    /**
     * Time/Space: O(4^n / n^(3/2))
     */
    private TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = cloneTree(root.left);
        newRoot.right = cloneTree(root.right);
        return newRoot;
    }

    private List<TreeNode> genTrees(int low, int high) {
        if (low > high) return Collections.singletonList(null);
        if (low == high) return Collections.singletonList(new TreeNode(low));
        List<TreeNode> result = new ArrayList<>();

        for (int i = low; i <= high; ++i) {
            List<TreeNode> lefts = genTrees(low, i - 1);
            List<TreeNode> rights = genTrees(i + 1, high);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = cloneTree(left);
                    root.right = cloneTree(right);
                    result.add(root);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n < 1) return Collections.emptyList();
        return genTrees(1, n);
    }
}
