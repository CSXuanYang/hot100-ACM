package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int curRight = 0, nextRight = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) {
                step++;
                curRight = nextRight;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        JumpGameII solution = new JumpGameII();
        System.out.print(solution.jump(nums));
    }
}
