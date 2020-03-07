package songren.Stack;

import java.util.Stack;

/**
 * Created by yesongren on 2020/3/7
 * 155. Min Stack
 */
public class LC155_MinStack {
    int[] arr;
    int index;
    int min;
    int size = 10;

    public void MinStack() {
        arr = new int[size];
        index = -1;
    }

    public void push(int x) {
        if (index == size - 1) {
            this.size *= 2;
            int[] kr = new int[this.size];
            for (int i = 0; i < this.arr.length; i++) {
                kr[i] = this.arr[i];
            }
            this.arr = kr;
        }
        arr[++index] = x;
        if (index == 0) {
            min = x;
        } else {
            min = min > arr[index] ? arr[index] : min;
        }
    }

    public void pop() {
        arr[index--] = 0;
        if (index == -1) {
            this.min = 0;
            return;
        }
        this.min = arr[index];
        for (int i = 0; i < index; i++) {
            this.min = arr[i] < this.min ? arr[i] : this.min;
        }
    }

    public int top() {
        if (index == -1) {
            return 0;
        }
        return arr[index];
    }

    public int getMin() {
        return min;
    }
}
