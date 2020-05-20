package src.category.JianZhiOffer.didi;

import java.util.PriorityQueue;
import java.util.Queue;

public class JZ41_MedianFinder {
}

class MedianFinder {

    /** initialize your data structure here. */
    private Queue<Long> minHeap = new PriorityQueue<>(), maxHeap = new PriorityQueue<>();

    public void addNum(int num) {
        maxHeap.add((long) num);
        minHeap.add(-maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.add(-minHeap.poll());
    }

    public double findMedian() {
        return maxHeap.size() > minHeap.size()
                ? maxHeap.peek()
                : (maxHeap.peek() - minHeap.peek()) / 2.0;
    }
}