package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        FindMinimumRotatedSortedArray solution = new FindMinimumRotatedSortedArray();
        System.out.println(solution.findMin(nums));
    }
}
