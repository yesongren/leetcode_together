package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/27
 * 面试题58 - I. 翻转单词顺序
 */
public class JZ58_1_ReverseWords {
    public String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals("")) {
                sb.append(a[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
