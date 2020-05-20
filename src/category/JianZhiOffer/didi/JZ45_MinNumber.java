package src.category.JianZhiOffer.didi;

import java.util.PriorityQueue;

public class JZ45_MinNumber {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] sNums = new String[len];
        for (int i = 0; i < len; i++)
            sNums[i] = String.valueOf(nums[i]);
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        for (int i = 0; i < len; i++)
            pq.offer(sNums[i]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(pq.poll());
        return sb.toString();
    }
}
