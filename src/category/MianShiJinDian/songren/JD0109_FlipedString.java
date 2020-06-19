package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/19
 * 面试题 01.09. 字符串轮转
 */
public class JD0109_FlipedString {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
