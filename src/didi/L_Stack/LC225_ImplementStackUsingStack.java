package src.didi.L_Stack;

import java.util.LinkedList;
import java.util.Queue;

public class LC225_ImplementStackUsingStack {
    private Queue<Integer> q;
    /** Initialize your data structure here. */
    public void MyStack() {
        this.q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        for (int i = 0; i < size - 1; i++) q.offer(q.poll());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
