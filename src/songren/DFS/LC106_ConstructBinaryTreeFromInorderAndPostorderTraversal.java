package songren.DFS;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/3/2
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inlen = inorder.length;
        int postlen = postorder.length;
        assert inlen == postlen;
        if (inlen == 0) {
            return null;
        }
        if (inlen == 1) {
            return new TreeNode(inorder[0]);
        }
        int rootVal = postorder[postlen - 1];
        int dividePoint = 0;
        for (int i = 0; i < inlen; i++) {
            if (inorder[i] == rootVal) {
                dividePoint = i;
                break;
            }
        }
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = buildTree(Arrays.copyOfRange(inorder, 0, dividePoint), Arrays.copyOfRange(postorder, 0, dividePoint));
        rootNode.right = buildTree(Arrays.copyOfRange(inorder, dividePoint + 1, inlen), Arrays.copyOfRange(postorder, dividePoint, postlen - 1));
        return rootNode;
    }
}
