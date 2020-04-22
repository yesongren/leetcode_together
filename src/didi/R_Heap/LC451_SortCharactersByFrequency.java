package src.didi.R_Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, (int) e.getValue())));
        }

        return sb.toString();
    }
}
