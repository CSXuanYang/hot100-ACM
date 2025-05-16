package Technique;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, p1, i);
                p1++;
            } else if (nums[i] == 0){
                swap(nums, p0, i);
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        SortColors solution = new SortColors();
        solution.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
