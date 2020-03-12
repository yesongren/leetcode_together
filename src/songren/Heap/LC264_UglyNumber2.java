package songren.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yesongren on 2020/3/12
 * 264. Ugly Number II
 */
public class LC264_UglyNumber2 {
    // Time: O(n*log(n)), Space: O(n)
    public int getNthUglyNumberMinHeap(int n) {
        int uglyNum = -1;
        Queue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n > 0) {
            while (q.peek() == uglyNum) q.poll();
            uglyNum = q.poll();
            if (2L * uglyNum <= Integer.MAX_VALUE)
                q.add(2 * uglyNum);
            if (3L * uglyNum <= Integer.MAX_VALUE)
                q.add(3 * uglyNum);
            if (5L * uglyNum <= Integer.MAX_VALUE)
                q.add(5 * uglyNum);
            --n;
        }
        return uglyNum;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // Time: O(n), Space: O(n)
    public int getNthUglyNumberDP(int n) {
        if (n <= 0) return -1;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int min = min(uglyNums[p2] * 2, uglyNums[p3] * 3, uglyNums[p5] * 5);
            uglyNums[i] = min;
            if (min == uglyNums[p2] * 2) ++p2;
            if (min == uglyNums[p3] * 3) ++p3;
            if (min == uglyNums[p5] * 5) ++p5;
        }
        return uglyNums[n - 1];
    }
}
