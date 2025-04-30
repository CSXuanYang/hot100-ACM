package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottingOranges {
    //    初始化队列，将所有腐烂橘子加入队列，并统计新鲜橘子的个数。
    //    如果没有新鲜橘子，直接返回 0。
    //    按层级向四个方向传播，更改橘子标记并更新新鲜橘子数量。
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;
            while (size > 0) {
                int[] rc = queue.poll();
                size--;
                for (int[] dir : dirs) {
                    int r = rc[0] + dir[0];
                    int c = rc[1] + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        freshCount--;
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        spread = true;
                    }
                }
            }
            if (spread) {
                ans++;
            }
        }

        return freshCount == 0 ? ans : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        s = s.replaceAll("\\[\\[", "")
                .replaceAll("]]", "")
                .replaceAll("\"", "");
        String[] rows = s.split("],\\[");
        int rowCount = rows.length;
        int colCount = rows[0].split(",").length;
        int[][] grid = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            int[] nums = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < colCount; j++) {
                grid[i][j] = nums[j];
            }
        }

        RottingOranges solution = new RottingOranges();
        System.out.println(solution.orangesRotting(grid));
    }
}
