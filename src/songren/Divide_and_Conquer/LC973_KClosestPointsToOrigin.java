package songren.Divide_and_Conquer;

import java.util.PriorityQueue;

/**
 * Created by yesongren on 2020/3/24
 * 973. K Closest Points to Origin
 */
public class LC973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        if(points.length==0||K>points.length||K<=0) return new int[0][0];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            if(pq.size()>K){
                pq.remove();
            }
        }
        return pq.toArray(new int[0][]);
    }
}
