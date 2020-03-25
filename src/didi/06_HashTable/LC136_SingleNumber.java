package didi.HashTable;

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer i : nums) {
            if (!set.add(i)) { // true if this set did not already contain the specified element
                set.remove(i);
            }
        }

//         Iterator<Integer> j = set.iterator();
//         while(j.hasNext())
//             return j.next();
//         return -1;

        return set.iterator().next();
    }

    public int singleNumber1(int[] nums) {
        int result = 0;

        for (Integer i : nums) {
            result ^= i;
        }

        return result;
    }
}