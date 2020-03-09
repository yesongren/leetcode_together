package songren.Sort;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/3/9
 * 179. Largest Number
 */
public class LC179_LargestNumber {
    private StringBuilder res;

    public String largestNumber(int[] nums) {
        res = new StringBuilder();
        Arrays.stream(nums).boxed().map(Object::toString).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}
