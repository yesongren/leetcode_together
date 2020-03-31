package didi.bitmanipulation;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> one = new HashSet<>();
        Set<String> two = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i, i + 10);
            if (!one.add(tmp)) {
                two.add(tmp);
            }
        }

        return new ArrayList(two);
    }
}