package songren.TwoPointers;

/**
 * Created by yesongren on 2020/3/6
 * 28. Implement strStr()
 */
public class LC028_ImplementstrStr {
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n-m; ++i) {
            int j = 0, k = i;
            while (j < m && k < n && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }
}
