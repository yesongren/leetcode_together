package src.didi.A_Array;

class LC011_Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxArea = 0, tmp = 0; // bug 1
        while (left != right){
            tmp = Math.min(height[left], height[right]) * (right - left);
            if (tmp > maxArea) maxArea = tmp;
            if (height[left] > height[right]) right--;
            else left++;
        }
        return maxArea;
    }
}