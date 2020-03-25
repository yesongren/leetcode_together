package didi.sort;

class NumbersComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0 || nums == null) return "";

        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
            strs[i] = Integer.toString(nums[i]);

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strs[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : strs)
            sb.append(s);

        return sb.toString();
    }
}