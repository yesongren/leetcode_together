package category.JianZhiOffer.songren;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/5/8
 * 面试题34. 二叉树中和为某一值的路径
 */
public class JZ34_PathSum {
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        path(root, sum, elem, result);
        return result;
    }
}
