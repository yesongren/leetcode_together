package category.JianZhiOffer.songren;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by yesongren on 2020/5/20
 * 面试题48. 最长不含重复字符的子字符串
 */
public class JZ48_LengthOfLongestSubstring {
    public int lengthOfLongestSubString(String s) {
        if (s == null || s.equals("")) return 0;
        int maxlen = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0, j = 0; i < s.length(); ) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i++));
            }
            maxlen = Math.max(maxlen, set.size());
        }
        return maxlen;
    }

    public int lengthOfLongestSubString2(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int pointer = 0, maxLen  = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dic.containsKey(s.charAt(i))) pointer = Math.max(dic.get(s.charAt(i)) + 1, pointer);
            maxLen = Math.max(i - pointer + 1, maxLen);
            dic.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
