package songren.Stack;

import java.util.Stack;

/**
 * Created by yesongren on 2020/3/7
 * 173. Binary Search Tree Iterator
 */
public class LC173_BinarySearchTreeIterator {
}

class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            s.add(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = s.pop();
        int res = n.val;
        if(n.right != null){
            n = n.right;
            while(n != null){
                s.push(n);
                n = n.left;
            }
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
