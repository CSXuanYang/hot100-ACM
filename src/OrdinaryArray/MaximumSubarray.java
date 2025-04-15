package OrdinaryArray;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarray {
    /*
    * 动态规划求解：
    * 1. 定义状态：dp[i]表示以nums[i]结尾的最大连续子数组和
    * 2. 状态转移：dp[i] = max(dp[i-1], 0) + nums[i]
    * 3. 初始条件：dp[0] = nums[0]
    * 4. 返回结果：max{dp[i]}
    * 时间复杂度：O(n)，空间复杂度O(1)
     */
    public static int maxSubArray(int[] nums) {
        // 定义状态
        int pre = nums[0];
        // 状态转移
        int ans = pre;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre, 0) + nums[i];
            ans = Math.max(ans, pre);
        }
        // 返回结果
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(maxSubArray(nums));
    }

}
