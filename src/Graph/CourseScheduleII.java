package Graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            inDeg[p[0]]++;
        }

        // 初始化队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }

        // 广度优先搜索
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[index++] = u;
            for (int v : graph.get(u)) {
                inDeg[v]--;
                if (inDeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return index == numCourses ? ans : new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        sc.close();
        s = s.replaceAll("\\[\\[", "")
                .replaceAll("]]", "");
        String[] rows = s.split("],\\[");
        int rowCount = rows.length;
        int[][] prerequisites = new int[rowCount][2];
        for (int i = 0; i < rowCount; i++) {
            int[] nums = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
            prerequisites[i][0] = nums[0];
            prerequisites[i][1] = nums[1];
        }

        CourseScheduleII solution = new CourseScheduleII();
        int[] ans = solution.findOrder(numCourses, prerequisites);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
    }
}
