package category.Daily_Challenge.songren;

import category.Daily_Challenge.songren.util.ListNode;
import category.Daily_Challenge.songren.util.TreeNode;

/**
 * Created by yesongren on 2020/8/18
 * 109. 有序链表转换二叉搜索树
 */
public class Daily_Aug18 {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        node = head;
        while(head != null){
            head = head.next;
            n++;
        }
        return toBST(0, n-1);
    }
    private TreeNode toBST(int left, int right){
        if(left > right) return null;
        int m = (left + right) / 2;
        TreeNode left_child = toBST(left, m-1);
        TreeNode father = new TreeNode(node.val);
        node = node.next;
        father.left = left_child;
        father.right = toBST(m+1, right);
        return father;
    }
}
