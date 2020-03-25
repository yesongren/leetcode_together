package didi.stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String cur : path.split("/")) {
            if (cur.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (cur.length() > 0 && !cur.equals(".")) {
                stack.push(cur);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        if (sb.length() == 0) return "/";

        return sb.toString();
    }
}

// wrong solution for case '/...'

//for (int i = 1; i < pathArray.length; i++) {
//    if (pathArray[i] == '/' && stack.peek() != '/')
//        stack.push(pathArray[i]);
//    if (Character.isLetter(pathArray[i]))
//        stack.push(pathArray[i]);
//    if (i + 1 < path.length() && pathArray[i] == '.' && pathArray[i+1] == '.') {
//        if (stack.peek() == '/'&& stack.size() > 1)
//            stack.pop();
//        while(stack.peek() != '/')
//            stack.pop();
//    }
//}