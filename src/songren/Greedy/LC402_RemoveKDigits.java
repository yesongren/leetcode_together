package songren.Greedy;

import java.util.Stack;

/**
 * Created by yesongren on 2020/4/9
 * 402. Remove K Digits
 */
public class LC402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length() - k;
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty() && stack.get(0) == '0') {
            stack.remove(0);
            n--;
        }
        for (int i = 0; i < n; i++) {
            res.append(stack.get(i));
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    /**
     * 来源评论区
     * 直接用了String的性质，来代替单调栈，速度更快，很巧妙
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigitsUsingString(String num, int k) {
        int remain = num.length() - k;
        char[] numArray = num.toCharArray(), res = new char[remain];
        int index = 0;
        for (int i = 0; i < numArray.length; i++) {
            // (1)  (n - i > remain - index): have enough remaining digits to be compared
            // (2)  (res[index - 1] > nums[i]): at this time, the (index-1) is the newest added digit,
            //      compare this digit with the current num, if the res is greater and you have enough
            //      remaining digits to be compared, decrease the index(it ensures that the future added digit is
            //      always smaller than before and the size is remain) until get the right and 'safe' position
            while ((numArray.length - i > remain - index) && (index > 0 && numArray[i] < res[index - 1])) index--;
            if (index < remain) res[index++] = numArray[i];
        }

        // check leading zeroes
        index = -1;
        while (++index < remain) {
            if (res[index] != '0') break;
        }
        String s = new String(res).substring(index);

        return s.length() == 0 ? "0" : s;
    }
}
