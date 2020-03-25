package didi.heap;

class Solution {
    // 14 ms
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2)); // 最小堆

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (int num: map.keySet()) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> top_k = new ArrayList<>();

        while (!heap.isEmpty())
            top_k.add(0,heap.poll());

        return top_k;
    }

    // 9 ms
    // Set<Integer>[] bucket = new HashSet[nums.length + 1];
    // List<Integer>[] bucket = new List[nums.length+1];
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for (int num: map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = bucket.length - 1; i > 0 && k > res.size(); --i) {
            if (bucket[i] != null) {
                // List<Integer> list = bucket[i];
                res.addAll(bucket[i]);
            }
        }

        return res;
    }
}