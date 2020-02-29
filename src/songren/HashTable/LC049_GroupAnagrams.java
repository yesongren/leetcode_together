package songren.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yesongren on 2020/2/29
 * 49. Group Anagrams
 */
public class LC049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char chars[] = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!strMap.containsKey(key)) {
                strMap.put(key, new ArrayList<String>());
            }
            strMap.get(key).add(str);
        }
        return new ArrayList(strMap.values());
    }
}
