package didi.String;

class Solution {
    private Map<Character,String> map = new HashMap<>() {{
        put('0', "");
        put('1', "");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() ==  0) return result;

        Helper(result, digits, "", 0);

        return result;
    }

    private void Helper(List<String> result, String digits, String curr, int idx) {
        if(idx == digits.length()) {
            result.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for(int i = 0; i < letters.length(); i++) {
            Helper(result, digits, curr + letters.charAt(i), idx + 1);
        }
    }
}