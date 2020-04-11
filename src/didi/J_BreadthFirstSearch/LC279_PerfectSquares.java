package src.didi.J_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class LC279_PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 1; i <= size; i++) {
                int num = q.poll();
                int r = (int) Math.sqrt(num);
                for (int j = r; j > 0; j--) {
                    int square = num - j * j;
                    if (square == 0) return count;
                    q.offer(square);
                }
            }
        }
        return -1;
    }
}
