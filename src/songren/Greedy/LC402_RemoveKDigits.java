package songren.Greedy;

import java.util.Stack;

/**
 * Created by yesongren on 2020/4/9
 * 402. Remove K Digits
 */
public class LC402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length() - k;
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty() && stack.get(0) == '0') {
            stack.remove(0);
            n--;
        }
        for (int i = 0; i < n; i++) {
            res.append(stack.get(i));
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
