package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/8
 * 面试题33. 二叉搜索树的后序遍历序列
 */
public class JZ33_VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 1){
            return true;
        }
        if(postorder.length == 0){
            return true;
        }
        return helper(postorder, 0, postorder.length - 1);

    }
    public boolean helper(int [] postorder,int left, int right){
        if(right <= left){
            return true;
        }
        int temp = left;

        while((temp < right)&&(postorder[temp] < postorder[right])){
            temp++;
        }
        for(int i = temp; i < right; i++){
            if(postorder[i] < postorder[right]){
                return false;
            }
        }

        return helper(postorder,left,temp - 1) && helper(postorder,temp,right - 1);
    }
}
