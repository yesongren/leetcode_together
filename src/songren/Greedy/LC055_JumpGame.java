package songren.Greedy;

/**
 * Created by yesongren on 2020/3/3
 * 55. Jump Game
 */
public class LC055_JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        if(nums[0] == 0){
            return false;
        }
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]==0){
                int count = 0;
                for(int j = i-1; j>=0; j--){
                    if(nums[j] > i-j){
                        break;
                    }else{
                        count++;
                    }
                }
                if( count==i){
                    return false;
                }
            }
        }
        return true;
    }
}
