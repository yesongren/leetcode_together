package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/10/12
 * 344. 反转字符串
 */
public class Daily_Oct08 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char tmp;
        while (i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
