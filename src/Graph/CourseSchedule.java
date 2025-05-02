package Graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses];

        // 深度优先搜索
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int u, List<List<Integer>> graph, int[] visited) {
        // 标记正在访问中
        visited[u] = 1;
        // 遍历邻接节点
        for (int v : graph.get(u)) {
            if (visited[v] == 1 || (visited[v] == 0 && dfs(v, graph, visited))) {
                return true;
            }
        }
        visited[u] = 2;
        return false;
    }

    public boolean canFinishIter(int numCourses, int[][] prerequisites) {
        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDeg = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            inDeg[p[0]]++;
        }
        // 广度优先
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v : graph.get(u)) {
                --inDeg[v];
                if (inDeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        s = s.replaceAll("\\[\\[", "")
                .replaceAll("]]", "");
        String[] rows = s.split("],\\[");
        int rowCount = rows.length;
        int colCount = rows[0].split(",").length;
        int[][] prerequisites = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            int[] nums = Arrays.stream(rows[0].split(",")).mapToInt(Integer::parseInt).toArray();
            prerequisites[i][0] = nums[0];
            prerequisites[i][1] = nums[1];
        }

        CourseSchedule solution = new CourseSchedule();
        System.out.println("递归：" + solution.canFinish(numCourses, prerequisites));
        System.out.println("迭代：" + solution.canFinishIter(numCourses, prerequisites));
    }
}
