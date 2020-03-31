package didi.HastTable;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node current = head;
        while(current != null) {
            Node copyNext = new Node(current.val);
            copyNext.next = current.next;
            current.next = copyNext;
            current = current.next.next;
        }

        Node current2 = head;
        while(current2 != null) { // care random could be null should avoid
            if (current2.random != null) {
                Node copyRandom = current2.next;
                copyRandom.random = current2.random.next;
            }
            current2 = current2.next.next; // not in if loop
        }

        Node current3 = head;
        Node dummy = new Node(0);
        Node copy = dummy; // need a copy
        while(current3 != null) {
            copy.next = current3.next;
            current3.next = current3.next.next;
            copy = copy.next;
            current3 = current3.next;
        }

        return dummy.next;
    }
}