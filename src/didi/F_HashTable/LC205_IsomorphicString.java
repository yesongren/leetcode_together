package src.didi.F_HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC205_IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character,Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!map.containsKey(a)) {
                if (!map.containsValue(b)) map.put(a,b);
                else return false;
            } else {
                if (map.get(a) == b) continue;
                else return false;
            }
        }

        return true;
    }
}
