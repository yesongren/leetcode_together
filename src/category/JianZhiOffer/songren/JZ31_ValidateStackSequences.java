package category.JianZhiOffer.songren;

import java.util.Stack;

/**
 * Created by yesongren on 2020/5/8
 */
public class JZ31_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() &&stack.peek() == popped[p]) {
                stack.pop();
                p++;
            }
        }
        return stack.isEmpty();
    }
}
