package songren.String;

/**
 * Created by yesongren on 2020/3/27
 * 125. Valid Palindrome
 */
public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
