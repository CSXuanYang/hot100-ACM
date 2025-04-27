package DP;

import java.util.Scanner;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        // 定义状态
        int[] dp = new int[n];
        int ans = 0;
        // 状态转移
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i-2] : 0) + 2;
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '('){
                    dp[i] = dp[i-1] + (i - 2 - dp[i-1] >= 0 ? dp[i-2-dp[i-1]] : 0) + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses(s));
        sc.close();
    }
}
