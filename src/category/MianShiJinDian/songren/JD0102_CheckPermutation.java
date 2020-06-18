package category.MianShiJinDian.songren;


/**
 * Created by yesongren on 2020/6/18
 * 面试题 01.02. 判定是否互为字符重排
 */
public class JD0102_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] tmp = new int[128];
        for (int i = 0; i < s1.length(); ++i) {
            tmp[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); ++i) {
            tmp[s2.charAt(i)]--;
        }
        for (int t : tmp) {
            if (t != 0) return false;
        }
        return true;
    }
}
