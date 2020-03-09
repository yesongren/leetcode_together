package didi.sort;

class Solution {
    public int[][] merge(int[][] intervals) {
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