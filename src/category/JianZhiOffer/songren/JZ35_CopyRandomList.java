package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/8
 * 面试题35. 复杂链表的复制
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

public class JZ35_CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = tmp;
            cur = tmp;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node copy_head = cur.next;
        Node copy_cur = copy_head;
        while (copy_cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;

            copy_cur.next = copy_cur.next.next;
            copy_cur = copy_cur.next;
        }
        cur.next = null;
        return copy_head;
    }
}
