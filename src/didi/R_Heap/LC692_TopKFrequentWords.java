package src.didi.R_Heap;

import java.util.*;

public class LC692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        while(k > 0){
            res.add(maxHeap.remove().getKey());
            k--;
        }

        return res;
    }
}
