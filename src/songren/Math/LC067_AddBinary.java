package songren.Math;

import java.math.BigInteger;

/**
 * Created by yesongren on 2020/3/26
 * 67. Add Binary
 */
public class LC067_AddBinary {
    public String addBinary(String a, String b) {
        BigInteger aNum = new BigInteger(a, 2);
        BigInteger bNum = new BigInteger(b, 2);
        BigInteger ans = aNum.add(bNum);
        return ans.toString(2);
    }
}
