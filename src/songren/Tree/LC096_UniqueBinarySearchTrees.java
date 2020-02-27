package songren.Tree;

/**
 * Created by yesongren on 2020/2/28
 * 96. Unique Binary Search Trees
 */
public class LC096_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        return getAns(1, n);
    }

    public int getAns(int start, int end) {
        int ans = 0;
        if (start >= end) return 1;
        for (int i = start; i <= end; i++) {
            int leftNum = getAns(start, i - 1);
            int rightNum = getAns(i + 1, end);
            ans += leftNum * rightNum;
        }
        return ans;
    }
}
