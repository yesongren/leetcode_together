package songren.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yesongren on 2020/3/7
 * 144. Binary Tree Preorder Traversal
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
public class LC144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            //stack.pop();
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.right != null) stack.push(tmp.right);
            if(tmp.left != null) stack.push(tmp.left);
        }
        return res;
    }
}
