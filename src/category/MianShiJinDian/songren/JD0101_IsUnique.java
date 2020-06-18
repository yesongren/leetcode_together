package category.MianShiJinDian.songren;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2020/6/18
 * 面试题 01.01. 判定字符是否唯一
 */
public class JD0101_IsUnique {
    // HashSet
    public boolean isUniqueSet(String astr) {
        Set<Character> set = new HashSet<>();
        char[] chs = astr.toCharArray();
        for (char ch : chs) {
            if (!set.add(ch)) return false;
        }
        return true;
    }

    // Bit Manipulation
    public boolean isUniqueBit(String astr) {
        int x = 0, c;
        for (int i = 0; i < astr.length(); ++i) {
            c = astr.charAt(i) - 'a';
            if (((x >> c) & 1) == 1) return false;
            x |= (1 << c);
        }
        return true;
    }
}
