package didi.string;

class Solution {
    public boolean isValid(String s) {
        if (s == null) return false;

        Map<Character,Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');

        Set<Character> leftPart = new HashSet();
        leftPart.add('(');
        leftPart.add('[');
        leftPart.add('{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (leftPart.contains(c)) stack.push(c);
                // else if (!pairs.containsKey(c)) continue;
            else{
                if (stack.isEmpty()) return false;
                char popped = stack.pop();
                if (popped != pairs.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}