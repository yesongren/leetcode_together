package songren.String;

import java.util.HashSet;

/**
 * Created by yesongren on 2020/2/27
 */
public class LC003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
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
}
