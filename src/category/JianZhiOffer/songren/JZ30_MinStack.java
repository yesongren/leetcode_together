package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/8
 * 面试题30. 包含min函数的栈
 */
public class JZ30_MinStack {

}

class MinStack {
    private int[] arr;
    private int index;
    private int min;
    private int size = 10;

    public MinStack() {
        arr = new int[size];
        index = -1;
    }

    public void push(int x) {
        if (index == size - 1) {
            this.size *= 2;
            int[] kr = new int[this.size];
            System.arraycopy(this.arr, 0, kr, 0, this.arr.length);
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