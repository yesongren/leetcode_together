package songren.Sort;

/**
 * Created by yesongren on 2020/4/17
 * 242. Valid Anagram
 */
public class LC242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] statS = new int[26];
        int[] statT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            statS[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            statT[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (statS[i] != statT[i]) return false;
        }
        return true;
    }
}
