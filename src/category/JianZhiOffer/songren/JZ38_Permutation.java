package category.JianZhiOffer.songren;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2020/5/10
 * 面试题38. 字符串的排列
 */
public class JZ38_Permutation {
    Set<String> res = new HashSet<>();

    public String[] permutation(String s) {
        if (s.length() == 0) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        backtrack(s, "", visited);
        return res.toArray(new String[0]);
    }

    private void backtrack(String s, String letter, boolean[] visited) {
        if (letter.length() == s.length()) {
            res.add(letter);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (visited[i]) continue;
            visited[i] = true;
            backtrack(s, letter + String.valueOf(tmp), visited);
            visited[i] = false;
        }
    }
}
