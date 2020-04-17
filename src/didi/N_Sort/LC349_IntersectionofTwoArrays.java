package src.didi.N_Sort;

import java.util.*;

public class LC349_IntersectionofTwoArrays {
    public int[] intersection1(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) return res.stream().mapToInt(i->i).toArray();

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i : B) setB.add(i);
        for (int i : A) setA.add(i);

        if (setA.size() >= setB.size()) {
            for (int i : setA){
                if (setB.contains(i)) res.add(i);
            }
        } else {
            for (int i : setB) {
                if (setA.contains(i)) res.add(i);
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }

    public int[] intersection(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) return new int[0];

        Set<Integer> set = new HashSet<>();
        for (int i : A) set.add(i);

        int[] res = new int[set.size()];

        int index = 0;
        for (int i : B) {
            if (set.remove(i)) res[index++] = i;
        }

        return Arrays.copyOfRange(res, 0, index);
    }
}
