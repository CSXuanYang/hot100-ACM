package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            if (i > mx) {
                return false;
            }
            mx = Math.max(mx, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        JumpGame solution = new JumpGame();
        System.out.print(solution.canJump(nums));
    }
}
