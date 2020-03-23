package didi.dq;

class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : result) {
                if (i * 2 - 1 <= N) {
                    tmp.add(i * 2 - 1);
                }
            }
            for (int i : result) {
                if (i * 2 <= N) {
                    tmp.add(i * 2);
                }
            }
            result = tmp;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}