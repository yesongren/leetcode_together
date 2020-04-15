package songren.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/4/15
 * 89. Gray Code
 */
public class LC089_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }
}
