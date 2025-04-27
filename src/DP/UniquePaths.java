package DP;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths {
    // dp[i][j] = dp[i-1][j]+dp[i][j-1]
    // 空间优化dp[j] += dp[j-1]
    public int uniquePaths(int m, int n) {
        // 定义状态
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(m, n));
        sc.close();
    }
}
