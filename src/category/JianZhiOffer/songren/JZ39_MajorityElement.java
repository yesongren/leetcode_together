package category.JianZhiOffer.songren;

import java.util.Stack;

/**
 * Created by yesongren on 2020/5/9
 * 面试题39. 数组中出现次数超过一半的数字
 */
public class JZ39_MajorityElement {
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty()) stack.push(num);
            else if (stack.peek() != num) stack.pop();
            else stack.push(num);
        }
        return stack.peek();
    }
}
