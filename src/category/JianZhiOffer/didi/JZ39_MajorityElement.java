package src.category.JianZhiOffer.didi;

import java.util.Stack;

public class JZ39_MajorityElement {
    public int majorityElement_Stack(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i : nums){
            if (stack. empty() || i == stack.peek()) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }

        return stack.peek();
    }
    public int majorityElement(int[] nums) {
        int count = 0, res = 0;

        for (int num : nums) {
            if (count == 0)
                res = num;
            if (num != res)
                count--;
            else
                count++;
        }

        return res;
    }
}
