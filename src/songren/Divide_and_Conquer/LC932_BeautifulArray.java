package songren.Divide_and_Conquer;

/**
 * Created by yesongren on 2020/3/24
 * 932. Beautiful Array
 */
public class LC932_BeautifulArray {
    private void solve(int[] num, int begin, int end, int[] temp) {
        if (end - begin <= 2) {
            return;
        }
        int pos = (end - begin + 1) >> 1;
        for (int i = begin; i < end; i += 2) {
            temp[begin + ((i - begin) >> 1)] = num[i];
            if (i < end - 1) {
                temp[begin + pos + ((i - begin) >> 1)] = num[i + 1];
            }
        }
        for (int i = begin; i < end; i++) {
            num[i] = temp[i];
        }
        solve(num, begin, begin + pos, temp);
        solve(num, begin + pos, end, temp);
    }

    public int[] beautifulArray(int N) {
        int[] num = new int[N], temp = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }
        if (N <= 2) {
            return num;
        }
        solve(num, 0, N, temp);
        return num;
    }
}
