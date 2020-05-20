package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/20
 * 面试题50. 第一个只出现一次的字符
 */
public class JZ50_FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] cnt = new int[26];
        char[] chs = s.toCharArray();

        for (char ch : chs) {
            cnt[ch - 'a']++;
        }

        for (char ch : chs) {
            if (cnt[ch - 'a'] == 1) return ch;
        }
        return ' ';
    }
}
