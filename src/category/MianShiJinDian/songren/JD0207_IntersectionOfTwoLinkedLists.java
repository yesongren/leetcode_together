package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/22
 * 面试题 02.07. 链表相交
 */
public class JD0207_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
