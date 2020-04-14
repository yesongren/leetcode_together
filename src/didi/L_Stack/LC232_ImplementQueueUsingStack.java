package src.didi.L_Stack;

import java.util.Stack;

public class LC232_ImplementQueueUsingStack {
    private Stack<Integer> input;
    private Stack<Integer> output;
    /** Initialize your data structure here. */
    public void MyQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!output.isEmpty()) return output.pop();
        while(!input.isEmpty()) output.push(input.pop());
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!output.isEmpty()) return output.peek();
        while(!input.isEmpty()) output.push(input.pop());
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
