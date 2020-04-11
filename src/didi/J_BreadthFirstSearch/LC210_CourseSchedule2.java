package src.didi.J_BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int[] degree = new int[numCourses];
        int[] output = new int[numCourses];
        int index = 0;
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++; // degree[被指向的课 = 想修的课 = 高阶课]
            graph[prerequisite[1]].add(prerequisite[0]); // graph[pre][高阶课]
        }

        Queue<Integer> visit = new LinkedList<Integer>();

        for(int i = 0; i < numCourses; i++){
            if (degree[i] == 0){
                output[index++] = i;
                visit.add(i); // 探索完毕的课程，下一个目标是这个课程的高阶课
            }
        }

        while(!visit.isEmpty()){
            int pre = visit.poll();
            for(int nextLevelCourse : graph[pre]){
                if(--degree[nextLevelCourse] == 0){
                    output[index++] = nextLevelCourse;
                    visit.add(nextLevelCourse);
                }
            }
        }
        return (index == numCourses) ? output : new int[0];
    }
}
