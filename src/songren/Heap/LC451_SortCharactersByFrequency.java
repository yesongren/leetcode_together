package songren.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by yesongren on 2020/4/22
 * 451. Sort Characters By Frequency
 */
public class LC451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!q.isEmpty()) {
            final Map.Entry<Character, Integer> item = q.poll();
            for (int i = 0; i < item.getValue(); i++) {
                stringBuilder.append(item.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
