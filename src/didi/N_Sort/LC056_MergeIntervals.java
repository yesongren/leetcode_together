package didi.sort;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        List<int[]> result = new ArrayList<>();

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;

        while (i < start.length) {
            int st = start[i];
            while (i < start.length - 1 && end[i] >= start[i + 1]) i++;
            int ed = end[i];
            result.add(new int[]{st, ed});
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }


    public int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        // System.out.println(Arrays.deepToString(intervals));

        int[] pre = intervals[0];
        result.add(pre);

        for (int[] curr : intervals) {
            if (curr[0] <= pre[1]){
                pre[1] = Math.max(pre[1], curr[1]);
            } else {
                pre = curr;
                result.add(pre);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}