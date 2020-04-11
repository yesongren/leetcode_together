package songren.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yesongren on 2020/4/10
 * 207. Course Schedule
 */
public class LC207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt += 1;
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }
}
