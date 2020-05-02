package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/2
 * 面试题05. 替换空格
 */
public class JZ05_ReplaceSpace {

    public String replaceSpace(String s) {
        char[] str = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char c : str) {
            if (c == ' ')
                ans.append("%20");
            else
                ans.append(c);
        }
        return ans.toString();
    }

    // Use "replace" func in String class
    public String replaceSpace2(String s) {
        s = s.replace(" ", "%20");
        return s;
    }
}
