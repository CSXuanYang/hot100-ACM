package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        // 固定一个元素
        for (int i = 0; i < n - 2; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针
            int target = -nums[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 跳过重复元素
                    for (left += 1; left < right && nums[left] == nums[left-1]; left++);
                    for (right -= 1; right > left && nums[right] == nums[right+1]; right--);
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        Sum3 solution = new Sum3();
        System.out.println(solution.threeSum(nums));
        sc.close();
    }
}
