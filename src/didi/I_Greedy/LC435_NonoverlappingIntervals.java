package src.didi.I_Greedy;

import java.util.Arrays;

public class LC435_NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[1] == b[1])? a[0] - b[0] : a[1] - b[1]);
        int res = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev[1]) {
                prev = intervals[i];
            } else {
                res++;
                prev = prev[1] <= intervals[i][1] ? prev : intervals[i];
            }
        }
        return res;
    }
}
