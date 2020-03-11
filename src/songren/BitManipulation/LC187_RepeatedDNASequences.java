package songren.BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yesongren on 2020/3/11
 * 187. Repeated DNA Sequences
 */
public class LC187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) return res;
        Set<String> set1 = new HashSet<>();  // substring have been traversal
        Set<String> set2 = new HashSet<>();  // eligible substring
        for (int i = 0; i + 10 <= s.length(); i++) {
            String seq = s.substring(i, i + 10);
            if (set1.contains(seq)) {
                set2.add(seq);
            }
            set1.add(seq);
        }
        res.addAll(set2);
        return res;
    }
}
