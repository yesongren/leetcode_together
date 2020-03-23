package didi.dp;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        int[] distances = new int[points.length];

        for (int i = 0; i < points.length; i++) distances[i] = distance(points[i]);

        Arrays.sort(distances);

        int max = distances[K - 1];

        int curr = 0;
        for (int i = 0; i < points.length; i++)
            if (distance(points[i]) <= max)
                result[curr++] = points[i];

        return result;
    }

    private int distance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}