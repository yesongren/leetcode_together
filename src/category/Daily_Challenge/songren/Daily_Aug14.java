package category.Daily_Challenge.songren;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2020/8/14
 * 20. 有效的括号
 */
public class Daily_Aug14 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            if (ch == '(' || ch == '[' || ch =='{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
