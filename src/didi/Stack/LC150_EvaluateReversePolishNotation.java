package didi.stack;

class Solution {
    private HashSet<String> set = new HashSet<>() {{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (!set.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else if (set.contains(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                if (tokens[i].equals("*")) result = a * b;
                else if (tokens[i].equals("+")) result = a + b;
                else if (tokens[i].equals("-")) result = a - b;
                else if (tokens[i].equals("/")) result = a / b;
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        String operators = "+-*/";

        for (String token : tokens) {
            if (!operators.contains(token)) {
                s.push(Integer.valueOf(token));
                continue;
            }

            int a = s.pop();
            int b = s.pop();

            if (token.equals("+")) {
                s.push(b + a);
            } else if(token.equals("-")) {
                s.push(b - a);
            } else if(token.equals("*")) {
                s.push(b * a);
            } else {
                s.push(b / a);
            }
        }

        return s.pop();
    }
}