package songren.String;

/**
 * Created by yesongren on 2020/3/27
 * 58. Length of Last Word
 */
public class LC058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
