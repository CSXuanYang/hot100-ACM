package DP;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxStart = 0, maxLen = 1;
        // 定义状态
        boolean[][] dp = new boolean[n][n];
        // 枚举结束位置
        for (int j = 1; j < n; j++) {
            // 枚举起始位置
            for (int i = 0; i < j; i++) {
                // 更新状态
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j - i <= 2) || dp[i+1][j-1];
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxStart = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        int maxStart = 0, maxLen = 1;
        // 枚举每个中心点
        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }
            while (right < n && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left - 1 > maxLen) {
                maxStart = left + 1;
                maxLen = right - left - 1;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println("动态规划：" + solution.longestPalindrome(s));
        System.out.println("中心扩散：" + solution.longestPalindrome2(s));
        sc.close();
    }
}
