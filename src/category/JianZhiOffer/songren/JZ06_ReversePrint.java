package category.JianZhiOffer.songren;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yesongren on 2020/5/2
 * 面试题06. 从尾到头打印链表
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class JZ06_ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
