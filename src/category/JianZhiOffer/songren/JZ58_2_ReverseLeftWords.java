package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/27
 * 面试题58 - II. 左旋转字符串
 */
public class JZ58_2_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
}
