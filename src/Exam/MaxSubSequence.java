package Exam;

import java.util.Scanner;

/**
 * 输入n，为字符串长度，第二行输入n个整数，表示价值，第三行输入一个长为n的字符串，只包含0和1。
 * 求：删除一些字符，使得字符串不会出现连续的"110"，且此时价值最大。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

public class MaxSubSequence {
        public static long maxValue(String s, int[] v) {
            int n = s.length();
            // dp[i][j] 表示处理到第i个字符，结尾状态为j时的最大价值
            // j的状态: 0=空, 1=结尾是1, 2=结尾是11
            long[][] dp = new long[n + 1][3];

            // 初始化第一行
            for (int j = 0; j < 3; j++) {
                dp[0][j] = 0;
            }

            // 遍历每个字符
            for (int i = 0; i < n; i++) {
                char curr = s.charAt(i);

                // 不选当前字符的情况
                for (int j = 0; j < 3; j++) {
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][j]);
                }

                // 选当前字符的情况
                if (curr == '0') {
                    // 当前字符是0
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0] + v[i]);
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][1] + v[i]);
                    // 如果前面是11，选择0会形成110，所以不能选
                } else {
                    // 当前字符是1
                    dp[i + 1][1] = Math.max(dp[i + 1][1], dp[i][0] + v[i]);
                    dp[i + 1][2] = Math.max(dp[i + 1][2], dp[i][1] + v[i]);
                }
            }

            // 返回最后一行中的最大值
            long result = 0;
            for (int j = 0; j < 3; j++) {
                result = Math.max(result, dp[n][j]);
            }
            return result;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(maxValue(s, a));
        }
}
