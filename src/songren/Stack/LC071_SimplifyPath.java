package songren.Stack;

import java.util.Stack;

/**
 * Created by yesongren on 2020/3/7
 * 71. Simplify Path
 */
public class LC071_SimplifyPath {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String value : s) {
            if (!stack.isEmpty() && value.equals(".."))
                stack.pop();
            else if (!value.equals("") && !value.equals(".") && !value.equals(".."))
                stack.push(value);
        }
        if (stack.isEmpty())
            return "/";

        StringBuilder res = new StringBuilder();
        for (String aStack : stack) {
            res.append("/").append(aStack);
        }
        return res.toString();
    }
}
