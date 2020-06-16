package category.JianZhiOffer.songren;

import java.util.Stack;

/**
 * Created by yesongren on 2020/5/3
 * 面试题09. 用两个栈实现队列
 */
public class JZ09_CQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public JZ09_CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
}
