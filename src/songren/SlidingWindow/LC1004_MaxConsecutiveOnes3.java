package songren.SlidingWindow;

/**
 * Created by yesongren on 2020/3/22
 * 1004. Max Consecutive Ones III
 */
public class LC1004_MaxConsecutiveOnes3 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int num1 = 0, num0 = 0;

        if (A.length == 0)
            return 0;

        for (right = 0; right < A.length; right++) {
            int temp = A[right];
            if (temp == 1)
                num1++;
            else
                num0++;

            if (num0 + num1 > num1 + K) {
                temp = A[left];
                if (temp == 1)
                    num1--;
                else
                    num0--;
                left++;
            }
        }
        return A.length - left;
    }
}
