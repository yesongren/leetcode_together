package src.didi.N_Sort;

public class LC274_HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] paper = new int[len + 1];

        for (int c : citations) {
            if (c > len) paper[len]++;
            else paper[c]++;
        }

        int count = 0;

        for (int i = len; i >= 0; i--) {
            count += paper[i];
            if (count >= i) return i;
        }

        return -1;
    }
}
