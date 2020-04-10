package src.didi.I_Greedy;

public class LC402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length() - k;
        char[] res = new char[num.length()];
        int size = 0;

        for (char c : num.toCharArray()) {
            while (size > 0 && res[size - 1] > c && k > 0) {
                size--;
                k--;
            }
            res[size++] = c;
        }

        int start = 0;
        while (start < len && res[start] == '0') start++;

        return start == len ? "0" : new String(res, start, len - start);
    }
}
