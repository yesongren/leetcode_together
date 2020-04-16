package src.didi.N_Sort;

public class LC242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) if (i != 0) return false;
        // return Arrays.stream(count).sum() == 0; // 1 + (-1) = 0
        return true;
    }
}
