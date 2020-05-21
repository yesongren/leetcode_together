package src.category.JianZhiOffer.didi;

public class JZ50_FirstUniqChar {
    public char firstUniqChar(String s) {
        int[] count = new int[128];
        char[] chs = s.toCharArray();

        for (char ch : chs) {
            count[ch]++;
        }

        for (char ch : chs) {
            if (count[ch] == 1) return ch;
        }
        return ' ';
    }
}
