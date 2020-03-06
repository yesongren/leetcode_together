package songren.TwoPointers;

/**
 * Created by yesongren on 2020/3/6
 * 27. Remove Element
 */
public class LC027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        int ahead = 0;
        while(ahead < nums.length){
            if(nums[ahead] != val){
                nums[cur++] = nums[ahead];
            }
            ahead++;
        }
        return cur;
    }
}
