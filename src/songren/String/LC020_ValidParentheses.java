package songren.String;

import java.util.Stack;

/**
 * Created by yesongren on 2020/3/27
 * 20. Valid Parentheses
 */
public class LC020_ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch =='[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char topchar = stack.pop();
                if (ch == ')' && topchar != '(') return false;
                if (ch == ']' && topchar != '[') return false;
                if (ch == '}' && topchar != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
