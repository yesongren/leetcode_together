package songren.Greedy;

/**
 * Created by yesongren on 2020/3/4
 * 392. Is Subsequence
 */
public class LC392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        int j = -1;
        for(int i = 0;i<arr.length;i++) {
            j = t.indexOf(arr[i],j+1);
            if(j==-1) {
                return false;
            }
        }
        return true;
    }
}
