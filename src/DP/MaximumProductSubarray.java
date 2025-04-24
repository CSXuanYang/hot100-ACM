package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // 定义状态
        int n = nums.length;
        int fmin = nums[0];
        int fmax = nums[0];
        int ans = fmax;
        // 状态转移
        for (int i = 1; i < n; i++) {
            int tmin = Math.min(nums[i], Math.min(fmin * nums[i], fmax * nums[i]));
            int tmax = Math.max(nums[i], Math.max(fmin * nums[i], fmax * nums[i]));
            fmin = tmin;
            fmax = tmax;
            ans = Math.max(ans, fmax);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        MaximumProductSubarray solution = new MaximumProductSubarray();
        System.out.println(solution.maxProduct(nums));
    }
}
