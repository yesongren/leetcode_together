package didi.trie;

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder result = new StringBuilder();
        Set<String> rootset = new HashSet();
        for (String root: dict) rootset.add(root);

        for (String str : sentence.trim().split("\\s+")) {
            String curr = "";
            for (int i = 0; i <= str.length(); i++) { // <= not <
                curr = str.substring(0,i);
                if (rootset.contains(curr)) {
                    // System.out.println(curr);
                    break;
                }
            }
            if (curr.length() > 0) result.append(" ");
            result.append(curr);
        }

        return result.toString().trim();
    }
}