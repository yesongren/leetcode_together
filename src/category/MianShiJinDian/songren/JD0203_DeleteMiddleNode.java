package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/20
 * 面试题 02.03. 删除中间节点
 */
public class JD0203_DeleteMiddleNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
