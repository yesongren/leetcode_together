package src.didi.Q_LinkedList;

import java.util.HashSet;

public class LC160_IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visted = new HashSet<>();

        while (headA != null) {
            visted.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visted.contains(headB)) return headB;
            headB=headB.next;
        }

        return null;
    }
}
