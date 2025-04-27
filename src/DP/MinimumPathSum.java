package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum {
    // dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
    // 空间优化：dp[j] = min(dp[j-1], dp[j]) + grid[i][j]
    public int minPathSum(int[][] grid) {
        // 定义状态
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                grid[i][j] = nums[j];
            }
        }

        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(grid));

        sc.close();
    }
}
