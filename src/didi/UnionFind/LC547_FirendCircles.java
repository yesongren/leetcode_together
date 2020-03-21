package didi.unionfind;

class Solution {
    public int findCircleNum(int[][] M) {
        int numCircles = 0;
        boolean[] visited = new boolean[M.length];

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                numCircles++;
                dfs(M, visited, i);
            }
        }

        return numCircles;
    }

    private void dfs(int[][] M, boolean[] visited, int idx) {
        if(visited[idx]) return;

        visited[idx] = true;
        int[] node = M[idx];

        for(int i = 0; i < node.length; i++) {
            if(node[i] == 1) dfs(M, visited, i);
        }
    }
}