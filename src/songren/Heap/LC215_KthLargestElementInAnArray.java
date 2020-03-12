package songren.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yesongren on 2020/3/12
 * 215. Kth Largest Element in an Array
 */
public class LC215_KthLargestElementInAnArray {
    // Time: O(n*log(k)), Space: O(k)
    public int findKthLargestMinHeap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low], i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] < pivot) --j;
            if (i < j) swap(nums, i, j);
            while (i < j && nums[i] >= pivot) ++i;
            if (i < j) swap(nums, i, j);
        }
        return i;
    }

    // Time(avg): O(n), Time(worst): O(n^2), Space: O(1)
    public int findKthLargestQuickSelect(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p == k - 1) return nums[p];
            else if (p > k - 1) high = p - 1;
            else low = p + 1;
        }
        return -1;
    }
}
