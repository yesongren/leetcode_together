package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/24
 * 459. 重复的子字符串
 */
public class Daily_Aug24 {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}
