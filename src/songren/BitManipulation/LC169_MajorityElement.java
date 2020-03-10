package songren.BitManipulation;

import java.util.Stack;

/**
 * Created by yesongren on 2020/3/11
 * 169. Majority Element
 */
public class LC169_MajorityElement {
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num :nums) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else if (stack.peek() == num) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }
        return stack.peek();
    }
}
