package songren.BinarySearch;

/**
 * Created by yesongren on 2020/4/6
 * 167. Two Sum II - Input array is sorted
 */
public class LC167_TwoSum2_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
