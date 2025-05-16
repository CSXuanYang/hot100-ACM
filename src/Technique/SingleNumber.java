package Technique;

import java.util.Arrays;
import java.util.Scanner;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(nums));
    }
}
