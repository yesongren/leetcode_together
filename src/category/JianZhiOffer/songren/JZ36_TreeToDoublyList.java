package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/10
 * 面试题36. 二叉搜索树与双向链表
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class JZ36_TreeToDoublyList {
    private Node pre = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        inOrder(root);

        pre.right = head;
        head.left = pre;

        return head;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (pre == null) {
            head = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }

        inOrder(root.right);
    }
}
