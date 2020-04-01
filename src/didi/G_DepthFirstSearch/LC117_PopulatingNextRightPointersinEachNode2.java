package src.didi.G_DepthFirstSearch;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class LC117_PopulatingNextRightPointersinEachNode2 {
    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;

        if (root.left != null) root.left.next = root.right;

        Node right = (root.right != null) ? root.right : root.left;
        Node next = root.next;

        while(next != null) {
            if (next.left != null || next.right != null) {
                right.next = (next.left != null) ? next.left : next.right;
                break;
            }
            next = next.next;
        }

        connect(root.right);
        connect(root.left);

        return root;
    }
}
