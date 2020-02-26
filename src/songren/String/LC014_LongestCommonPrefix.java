package songren.String;

/**
 * Created by yesongren on 2020/2/27
 * 14. Longest Common Prefix
 */
public class LC014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        else if (strs.length == 1) return strs[0];
        else {
            String res = strs[0];
            for (int i = 1; i < strs.length; i++) {
                res = lcp(res, strs[i]);
            }
            return res;
        }
    }

    public String lcp(String str, String strs) {
        if (str.length() > strs.length()) return lcp(strs, str);
        else
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != strs.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        return str;
    }
}
