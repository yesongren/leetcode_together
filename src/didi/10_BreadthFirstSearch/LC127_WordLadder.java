package didi.bfs;

class Solution {
    HashMap<String,List<String>> map = new HashMap<>();

    private void buildMap (List<String> wordList, String beginWord){
        HashSet<String> wordSet = new HashSet<>();

        for (String str: wordList) wordSet.add(str);

        wordSet.add(beginWord);

        for (String str: wordSet) {
            map.put(str, new LinkedList<String>());
            diff(str, wordSet);
        }
    }

    private void diff(String str, HashSet<String> set) {
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            char curr = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (curr != c) {
                    sb.setCharAt(i, c);
                    if (set.contains(sb.toString())) map.get(str).add(sb.toString());
                }
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        buildMap(wordList, beginWord);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        int step = 1;
        visited.add(beginWord);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return step; //.equals()

                List<String> child = map.get(curr);
                for (String childString: child) {
                    if (!visited.contains(childString)) {
                        queue.offer(childString);
                        visited.add(childString);
                    }
                }
            }
            step++;
        }

        return 0;
    }
}