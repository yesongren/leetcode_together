package songren.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/2/24
 * 62. Unique Paths
 */
public class LC062_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] form = new int[n];

        Arrays.fill(form, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                form[j] += form[j - 1];
            }
        }

        return form[n - 1];
    }
}
