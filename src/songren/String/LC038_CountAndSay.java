package songren.String;

/**
 * Created by yesongren on 2020/3/27
 * 38. Count and Say
 */
public class LC038_CountAndSay {
    public static String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; i++) {
            String currentStr = new String(ans);
            ans.delete(0, ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if (c == currentChar) {
                    num++;
                } else {
                    ans.append((char) ('0' + num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char) ('0' + num));
            ans.append(currentChar);

        }
        return ans.toString();
    }
}
