package songren.Greedy;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/9
 * 452. Minimum Number of Arrows to Burst Balloons
 */
public class LC452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] != point2[1]) {
                return point1[1] - point2[1];
            }
            return point1[0] - point2[0];
        });

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
