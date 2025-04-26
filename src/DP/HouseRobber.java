package DP;

import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
    // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    public int rob(int[] nums) {
        int n = nums.length;
        int f0 = 0, f1 = nums[0];
        for (int i = 1; i < n; i++) {
            int f2 = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }

    public static void main(String[] aegs) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        HouseRobber solution = new HouseRobber();
        sc.close();
    }
}
