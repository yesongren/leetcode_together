package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/22
 * 面试题52. 两个链表的第一个公共节点
 */
public class JZ52_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pa;
    }
}
