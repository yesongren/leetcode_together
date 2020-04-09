package songren.Greedy;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/9
 * 435. Non-overlapping Intervals
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class LC435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}
