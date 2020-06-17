package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/6/16
 * 面试题64. 求1+2+…+n
 */
public class JZ64_SumNums {
    public int sumNums(int n) {
        int sum = n;
        // return n == 0 ? 0 : n + sumNums(n - 1);
        boolean flag = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}
