package Technique;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int votes = 0, candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                votes++;
            } else {
                votes--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(nums));
    }
}
