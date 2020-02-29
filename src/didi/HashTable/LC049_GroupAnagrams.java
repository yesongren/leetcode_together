package didi.HashTable;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if(! map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>()); // new ArrayList not new List<String>
            }
            map.get(sorted).add(word);
        }

        groupAnagrams.addAll(map.values());

        return groupAnagrams;
    }
}