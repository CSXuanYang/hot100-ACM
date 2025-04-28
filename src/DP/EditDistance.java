package DP;

import java.util.Scanner;

public class EditDistance {
    // 插入：dp[i][j] = dp[i-1][j] + 1
    // 删除：dp[i][j] = dp[i][j-1] + 1
    // 替换：dp[i][j] = dp[i-1][j-1] + 1
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        EditDistance solution = new EditDistance();
        System.out.println(solution.minDistance(word1, word2));
        sc.close();
    }
}
