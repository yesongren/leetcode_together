package category.JianZhiOffer.songren;

import java.util.*;

/**
 * Created by yesongren on 2020/5/19
 * 面试题41. 数据流中的中位数
 */

class MedianFinderArray {
    private final List<Integer> data = new ArrayList<>();

    // Time: O(n)
    public void addNum(int num) {
        int idx = data.size() - 1;
        while (idx >= 0 && data.get(idx) > num) --idx;
        data.add(idx + 1, num);
    }

    // Time: O(1)
    public double findMedian() {
        int n = data.size();
        if ((n & 1) == 1) {
            return data.get(n / 2);
        } else {
            return (data.get(n / 2 - 1) + data.get(n / 2)) / 2.0;
        }
    }
}

class MedianFinderHeap {

    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // Time: O(log(n))
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() - minHeap.size() > 1)
            minHeap.add(maxHeap.poll());
    }

    // Time: O(1)
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

public class JZ41_MedianFinder {
}
