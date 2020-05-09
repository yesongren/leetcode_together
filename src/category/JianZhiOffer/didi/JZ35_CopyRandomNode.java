package src.category.JianZhiOffer.didi;

public class JZ35_CopyRandomNode {
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
        while(current2 != null) {
            if (current2.random != null) {
                Node copyRandom = current2.next;
                copyRandom.random = current2.random.next;
            }
            current2 = current2.next.next;
        }

        Node current3 = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while(current3 != null) {
            copy.next = current3.next;
            current3.next = current3.next.next;
            copy = copy.next;
            current3 = current3.next;
        }

        return dummy.next;
    }
}

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
