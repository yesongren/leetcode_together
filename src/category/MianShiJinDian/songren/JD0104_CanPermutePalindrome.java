package category.MianShiJinDian.songren;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yesongren on 2020/6/18
 * 面试题 01.04. 回文排列
 */
public class JD0104_CanPermutePalindrome {
    // HashMap
    public boolean canPermutePalindromeMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }
        int cnt = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) cnt++;
        }
        return (cnt <= 1);
    }

    //HashSet
    public boolean canPermutePalindromeHashSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!set.add(ch)) {
                set.remove(ch);
            }
        }
        return set.size() <= 1;
    }
}
