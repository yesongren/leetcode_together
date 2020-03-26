package songren.Math;

/**
 * Created by yesongren on 2020/3/26
 * 168. Excel Sheet Column Title
 */
public class LC168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            char c = (char) (n % 26 + 'A');
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
