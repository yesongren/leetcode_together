package songren.BFS;

import java.util.*;

/**
 * Created by yesongren on 2020/4/10
 * 210. Course Schedule II
 */
public class LC210_CourseSchedule2 {
    Map<Integer, List> map = new HashMap();
    Stack<Integer> stack = new Stack();
    boolean hasCir = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] isSearched = new boolean[numCourses];
        Arrays.fill(isSearched, false);
        boolean[] isSearchedThis = new boolean[numCourses];

        buildTree(prerequisites);
        for (int i = 0; i < numCourses; i++) {
            Arrays.fill(isSearchedThis, false);
            DFS(i, isSearched, isSearchedThis);
        }

        if (hasCir)
            return new int[0];
        else {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                res[i] = stack.pop();
            return res;
        }

    }

    public void buildTree(int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][1]))
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            else {
                List<Integer> temp = new ArrayList();
                temp.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], temp);
            }
        }
    }

    public void DFS(int course, boolean[] isSearched, boolean[] isSearchedThis) {
        if (isSearchedThis[course]) {
            hasCir = true;
            return;
        }

        if (isSearched[course])
            return;

        isSearched[course] = true;
        isSearchedThis[course] = true;

        if (!map.containsKey(course))
            stack.push(course);
        else {
            for (int i = 0; i < map.get(course).size(); i++) {
                boolean[] temp = Arrays.copyOf(isSearchedThis, isSearchedThis.length);
                DFS((int) map.get(course).get(i), isSearched, temp);
            }

            stack.push(course);
        }
    }
}
