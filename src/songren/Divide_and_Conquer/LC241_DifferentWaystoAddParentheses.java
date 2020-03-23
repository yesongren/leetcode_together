package songren.Divide_and_Conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/3/23
 * 241. Different Ways to Add Parentheses
 */
public class LC241_DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int leftVal : left) {
                    for (int rightVal : right) {
                        switch (c) {
                            case '+':
                                box.add(leftVal + rightVal);
                                break;
                            case '-':
                                box.add(leftVal - rightVal);
                                break;
                            case '*':
                                box.add(leftVal * rightVal);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (box.size() == 0) {
            box.add(Integer.valueOf(input));
        }
        return box;
    }
}
