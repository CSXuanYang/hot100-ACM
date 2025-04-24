package DP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // 定义状态
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 枚举结束位置
        int ans = 1;
        for (int i = 1; i < n; i++) {
            // 枚举上一个数字
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        System.out.println(solution.lengthOfLIS(nums));
    }
}
