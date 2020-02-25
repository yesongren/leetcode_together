package songren.Math;

/**
 * Created by yesongren on 2020/2/26
 * 9. Palindrome Number
 */
public class LC009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        int tmp = x;
        if(x == 0) return true;
        if(x < 0) return false;
        int reverse = 0;
        while(x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return tmp == reverse;
    }
}
