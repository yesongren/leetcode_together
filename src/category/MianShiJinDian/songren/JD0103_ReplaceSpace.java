package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/19
 * 面试题 01.03. URL化
 */
public class JD0103_ReplaceSpace {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
