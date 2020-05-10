package src.category.JianZhiOffer.didi;

public class JZ36_TreeTODoublyList {
    private Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;

        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node curr) {
        if (curr == null) return;

        dfs(curr.left);
        if (pre == null) head = curr;
        else pre.right = curr;
        curr.left = pre;
        pre = curr;
        dfs(curr.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
