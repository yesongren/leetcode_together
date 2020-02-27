package songren.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/2/28
 * 95. Unique Binary Search Trees II
 */
public class LC095_UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
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
}
