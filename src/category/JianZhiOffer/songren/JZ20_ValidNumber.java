package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/6
 * 面试题20. 表示数值的字符串
 */
public class JZ20_ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean eSeen = false;
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean numberAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //number
            if (c >= '0' && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            }
            //exponent
            else if (c == 'e') {
                if (eSeen || !numberSeen) return false; // 字符串中最多出现一个e && e的前面必须要有数字
                eSeen = true;
                numberAfterE = false;
            }
            //+. -
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false; // +-号只能出现在最前面，或者是e后面，取反: 不是第一个字符，且前面不是e
            }
            //.
            else if (c == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            }
            //letter a,b,c..
            else {
                return false;
            }
        }
        return numberAfterE;
    }
}
