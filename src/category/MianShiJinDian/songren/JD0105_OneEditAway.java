package category.MianShiJinDian.songren;

import java.util.*;

/**
 * Created by yesongren on 2020/6/18
 * 面试题 01.05. 一次编辑
 */

/**
 * Explanation:
 *
 * 情况1：leetcode 与 leetkode
 * 那么我们需要找到 'c' 和 'k'，然后比较 'ode' 和 'ode' 是否相同。
 * 情况2：leetcode 与 leetode
 * 我们发现 'c' 和 'o' 不相同，然后比较 'ode' 和 'ode' 是否相同。
 */
public class JD0105_OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len1 < len2) return oneEditAway(second, first);
        for (int i = 0; i < len2; ++i) {
            if (first.charAt(i) != second.charAt(i)) {
                // 如果是长度相同字符串，那就继续比较下一个字符，如果长度不一样，那就从当前字符开始进行比较。
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }
}
