package songren.Stack;

import java.util.LinkedList;

/**
 * Created by yesongren on 2020/4/14
 * 331. Verify Preorder Serialization of a Binary Tree
 */
public class LC331_VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder.isEmpty())
            return true;
        LinkedList<String> stack = new LinkedList<>();
        String[] strings = preorder.split(",");
        if (strings[0].equals("#")) {
            return strings.length == 1;
        }
        stack.push(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if (stack.isEmpty())
                return false;
            if (!stack.pop().isEmpty())
                stack.push("");
            if (!strings[i].equals("#")) {
                stack.push(strings[i]);
            }
        }
        return stack.isEmpty();
    }
}
