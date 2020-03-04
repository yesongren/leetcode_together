package songren.BFS;

import java.util.*;

/**
 * Created by yesongren on 2020/3/4
 * 127. Word Ladder
 */
public class LC127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] word = cur.toCharArray();
                if (cur.equals(endWord)) return level + 1;
                for (int j = 0; j < cur.length(); j++) {
                    char tmp = word[j];
                    for (char c = 'a'; c <'z'; c++) {
                        word[j] = c;
                        String s = new String(word);
                        if (set.contains(s)) {
                            q.add(s);
                            set.remove(s);
                        }
                    }
                    word[j] = tmp;
                }
            }
            level++;
        }
        return 0;
    }
}
