package DP;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        // 计算和
        int n = nums.length;
        int sum = 0, maxNum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        // 剪枝优化
        int target = sum / 2;
        if (sum % 2 == 1 || maxNum > target) {
            return false;
        }

        // 定义状态
        boolean[] dp = new boolean[target + 1];
        dp[nums[0]] = true;
        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] | dp[j-nums[i]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        System.out.println(solution.canPartition(nums));
        sc.close();
    }
}
