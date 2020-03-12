package didi.heap;

class Solution {
    // 14 ms
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        int left = 0, right = nums.length - 1, target = nums.length - k;

        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return -1;
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = right;
        int slow = left - 1;
        int fast = left;

        while (fast < pivot) {
            if (nums[fast] > nums[pivot]) {
                fast++;
            } else {
                swap(nums, fast++, ++slow);
            }
        }
        swap(nums, ++slow, pivot);
        return slow;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    // 1 ms
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 4 ms
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}