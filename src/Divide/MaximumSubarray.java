package Divide;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarray {
    /*
     * 分治法求解：
     * 1. 定义状态：维护四个变量lSum,rSum,mSum,iSum
     * 2. pushup：合并两个状态
     * 3. get：获取区间和
     * 时间复杂度：O(n)，空间复杂度O(logn)
     */
    public static class Status {
        int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public static Status pushup(Status left, Status right) {
        int iSum = left.iSum + right.iSum;
        int lSum = Math.max(left.lSum, left.iSum + right.lSum);
        int rSum = Math.max(right.rSum, right.iSum + left.rSum);
        int mSum = Math.max(left.rSum + right.lSum, Math.max(left.mSum, right.mSum));
        return new Status(lSum, rSum, mSum, iSum);
    }

    public static Status get(int[] nums, int left, int right) {
        // 递归结束
        if (left == right) {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }

        // 分治法求区间和
        int mid = (left + right) >> 1;
        Status lSub = get(nums, left, mid);
        Status rSub = get(nums, mid + 1, right);

        return pushup(lSub, rSub);
    }

    public static int maxSubArray(int[] nums) {
        return get(nums,0, nums.length-1).mSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(maxSubArray(nums));
    }
}
