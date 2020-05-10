package src.category.JianZhiOffer.didi;

import java.util.*;

public class JZ38_Permutation {
    Set<String> res = new HashSet<>();

    public String[] permutation1(String s) {
        boolean[] visited = new boolean[s.length()];
        helper("", visited, s);
        String[] strs = new String[res.size()];
        int i = 0;
        for (String str : res) {
            strs[i++] = str;
        }
        return strs;
    }

    private void helper(String curr, boolean[] visited, String s) {
        if (curr.length() == s.length()) {
            res.add(curr);
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (visited[i]) continue;
                char c = s.charAt(i);
                visited[i] = true;
                helper(curr + c, visited, s);
                visited[i] = false;
            }
        }
    }

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder str = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        List<String> res = new ArrayList<>();
        backTrack(arr, str, visited, res);
        return res.toArray(new String[0]);
    }

    public void backTrack(char[] arr, StringBuilder str, boolean[] visited, List<String> res){
        if(str.length() == arr.length){
            res.add(str.toString());
            return;
        }
        for(int i = 0;i < arr.length;i++){
            if(!visited[i]){
                if(i > 0 && arr[i] == arr[i-1] && visited[i - 1]) continue;
                str.append(arr[i]);
                visited[i] = true;
                backTrack(arr, str, visited, res);
                str.deleteCharAt(str.length()-1);
                visited[i] = false;
            }
        }
    }
}
