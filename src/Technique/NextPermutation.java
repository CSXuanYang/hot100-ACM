package Technique;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 查找相邻升序对
        int n = nums.length;
        int i = n - 2, j = n - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        // 查找第一个大于nums[i]的
        if (i >= 0) {
            int k = n - 1;
            while (k >= j && nums[i] >= nums[k]) {
                k--;
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
        // 逆置
        int left = j, right = n - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
