package songren.Array;

/**
 * Created by yesongren on 2020/2/23
 * 011. Container With Most Water
 *
 * two pointers
 */
public class LC011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int tmpArea = 0; //init = 0 is redundant
        int maxArea = 0;
        while(left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            if (leftVal > rightVal) {
                tmpArea = rightVal * (right - left);
                right--;
            } else {
                tmpArea = leftVal * (right - left);
                left++;
            }
            maxArea = Math.max(maxArea, tmpArea);
        }
        return maxArea;
    }
}
