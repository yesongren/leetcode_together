package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/3
 * 面试题11. 旋转数组的最小数字
 */
public class JZ11_MinArray {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++)
            if (numbers[i] > numbers[i + 1]) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            }
        return numbers[0];
    }
}
