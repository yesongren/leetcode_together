package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/4
 * 面试题13. 机器人的运动范围
 */
public class JZ13_MovingCount {
    private int cnt = 0;

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        helper(visited,0,0,m,n,k);
        return cnt;
    }

    private void helper(int[][] visited,int i,int j,int m,int n,int k){

        if(i < m && j < n && visited[i][j] != 1 && (indexSum(i) + indexSum(j)) <= k){
            cnt++;
            visited[i][j] = 1;
            helper(visited,i+1,j,m,n,k);
            helper(visited,i,j+1,m,n,k);
        }
    }

    private int indexSum(int index){
        int sum = index%10;
        int tmp = index/10;
        while(tmp>0){
            sum +=tmp % 10;
            tmp /= 10;
        }
        return sum;
    }
}
