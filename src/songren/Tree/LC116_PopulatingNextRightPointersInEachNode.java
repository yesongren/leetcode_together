package songren.Tree;

/**
 * Created by yesongren on 2020/3/29
 * 116. Populating Next Right Pointers in Each Node
 */
public class LC116_PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left, right, next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time: O(n), Space: O(log(n))
    public Node connectRecursive(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }

    // Time: O(n), Space: O(1)
    public Node connectIterative(Node root) {
        if (root == null) return null;
        Node leftMost = root, p;
        while (leftMost.left != null) {
            p = leftMost;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null)
                    p.right.next = p.next.left;
                p = p.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
