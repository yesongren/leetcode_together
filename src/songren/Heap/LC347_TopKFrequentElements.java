package songren.Heap;

import java.util.*;

/**
 * Created by yesongren on 2020/3/12
 * 347. Top K Frequent Elements
 */
public class LC347_TopKFrequentElements {
    /**
     * 1. Min Heap
     * Time: O(n*log(k)), Space: O(n)
     */
    public List<Integer> topKFrequentMinHeap(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : pq) res.add(entry.getKey());
        return res;
    }

    /**
     * 2. Quick Select
     * Time(avg): O(n), Time(worst): O(n^2), Space: O(n)
     */
    private int partition(List<Map.Entry<Integer, Integer>> entries, int low, int high) {
        int pivot = entries.get(low).getValue();
        int i = low, j = high;
        while (i < j) {
            while (i < j && entries.get(j).getValue() < pivot) --j;
            if (i < j) Collections.swap(entries, i, j);
            while (i < j && entries.get(i).getValue() >= pivot) ++i;
            if (i < j) Collections.swap(entries, i, j);
        }
        return i;
    }

    public List<Integer> topKFrequentQuickSelect(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        int low = 0, high = entries.size() - 1;
        while (low <= high) {
            int p = partition(entries, low, high);
            if (p == k - 1) break;
            else if (p > k - 1) high = p - 1;
            else low = p + 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ++i)
            result.add(entries.get(i).getKey());
        return result;
    }

    /**
     * 3. Bucket Sort
     * Time: O(n), Space: O(n)
     */
    public List<Integer> topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; ++i) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet())
            buckets.get(e.getValue()).add(e.getKey());

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0 && k > 0; --i) {
            List<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size() && k > 0; ++j) {
                result.add(bucket.get(j));
                --k;
            }
        }
        return result;
    }
}
