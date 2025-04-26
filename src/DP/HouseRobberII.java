package DP;

import java.util.Arrays;
import java.util.Scanner;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int f0 = nums[start], f1 = Math.max(f0, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
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
        HouseRobberII solution = new HouseRobberII();
        System.out.println(solution.rob(nums));
        sc.close();
    }
}
