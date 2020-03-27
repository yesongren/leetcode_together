package songren.String;

/**
 * Created by yesongren on 2020/3/27
 * 6. ZigZag Conversion
 */
public class LC006_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int len = Math.min(s.length(), numRows);
        String[] rows = new String[len];
        for (int i = 0; i < len; i++) rows[i] = "";
        int loc = 0;
        boolean down = false;

        for (int i = 0; i < s.length(); i++) {
            rows[loc] += s.substring(i, i + 1);
            if (loc == 0 || loc == numRows - 1)
                down = !down;
            loc += down ? 1 : -1;
        }

        String ans = "";
        for (String row : rows) {
            ans += row;
        }
        return ans;
    }
}
