package songren.DynamicProgramming;

/**
 * Created by yesongren on 2020/3/25
 * 91. Decode Ways
 */
public class LC091_DecodeWays {
    private boolean isValidTwoDigit(char a, char b) {
        return (a == '1' && b <= '9') || (a == '2' && b <= '6');
    }

    private int decode(char[] c, int i) {
        if (i == c.length) return 1;
        if (i > c.length) return 0;
        int num = 0;
        if (c[i] != '0') num += decode(c, i + 1);
        if (i + 1 < c.length && isValidTwoDigit(c[i], c[i + 1])) num += decode(c, i + 2);
        return num;
    }

    public int numberOfDecodingsRecursive(String s) {
        return decode(s.toCharArray(), 0);
    }

    // Time: O(n), Space: O(n)
    public int numberOfDecodingsDP(String s) {
        int[] d = new int[s.length() + 1];
        d[0] = 1;
        d[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); ++i) {
            if (s.charAt(i - 1) != '0') d[i] += d[i - 1];
            if (isValidTwoDigit(s.charAt(i - 2), s.charAt(i - 1))) d[i] += d[i - 2];
        }
        return d[s.length()];
    }

    // Time: O(n), Space: O(1)
    public int numberOfDecodingsDPOptimal(String s) {
        int first = 1;
        int second = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); ++i) {
            int third = 0;
            if (s.charAt(i - 1) != '0') third += second;
            if (isValidTwoDigit(s.charAt(i - 2), s.charAt(i - 1))) third += first;
            first = second;
            second = third;
        }
        return second;
    }
}
