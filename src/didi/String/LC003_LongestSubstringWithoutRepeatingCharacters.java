package didi.String;


class Solution {
    // Brute Force
    public int max = 0, tmp = 0;

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0 || s == "") return 0;

        for (int i = 0; i < s.length(); i++){
            String substring = s.substring(i,s.length());
            tmp = uniqueSubstringLength(substring);
            max = Math.max(tmp,max);
        }

        return max;
    }

    private int uniqueSubstringLength(String s){
        HashSet<Character> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++){
            if (result.contains(s.charAt(i))) return result.size();
            else result.add(s.charAt(i));
        }

        return result.size();
    }
    // Sliding Window (moving pointer)
    public int max = 0;

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == "") return 0;

        HashMap<Character,Integer> check = new HashMap<>();

        int left = 0, right = 0;

        while (right < s.length()) {
            if (check.containsKey(s.charAt(right))){
                left = Math.max(check.get(s.charAt(right)), left);
            }
            max = Math.max(max, right - left + 1);
            check.put(s.charAt(right), right + 1);
            right++;
        }

        return max;
    }
}