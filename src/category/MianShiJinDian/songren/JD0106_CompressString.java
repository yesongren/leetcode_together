package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/19
 * 面试题 01.06. 字符串压缩
 */
public class JD0106_CompressString {
    public String compressString(String s) {
        if (s == null || s.length() < 3) return s;
        int cnt = 0;
        char c = s.charAt(0);
        StringBuilder res = new StringBuilder().append(c);
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                cnt++;
            } else {
                res.append(cnt);
                c = ch;
                res.append(c);
                cnt = 1;
            }
        }
        return res.append(cnt).length() < s.length() ? res.toString() : s;
    }
}
