package songren.HashTable;

/**
 * Created by yesongren on 2020/3/1
 * 138. Copy List with Random Pointer
 */
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

public class LC138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur = head;
        Node next = null;
        while(cur!=null){
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            cur.next.random = cur.random != null?cur.random.next:null;
            cur = next;
        }
        cur = head;
        Node newHead = cur.next;
        Node copyCur = null;
        while(cur!=null){
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next!=null?next.next:null;
            cur = next;
        }
        return newHead;
    }
}
