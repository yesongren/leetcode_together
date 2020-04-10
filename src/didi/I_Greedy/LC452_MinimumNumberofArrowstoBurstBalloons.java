package src.didi.I_Greedy;

import java.util.Arrays;

public class LC452_MinimumNumberofArrowstoBurstBalloons {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length == 0 || points[0].length == 0) return 0;

            Arrays.sort(points, (a, b) -> (a[1] == b[1])? a[0] - b[0] : a[1] - b[1]);
            int count = 1;
            int[] prev = points[0];

            for (int i = 1; i < points.length; i++) {
                if (prev[1] >= points[i][0]) continue;
                count++;
                prev = points[i];
            }

            return count;
        }
    }
}
