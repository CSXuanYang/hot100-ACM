package Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        // 使用集合去重
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // 遍历集合
        int ans = 0;
        for (int x : set) {
            // 确定序列起始
            if (!set.contains(x - 1)) {
                int curNum = x + 1, curLen = 1;
                while (set.contains(curNum)) {
                    curNum++;
                    curLen++;
                }
                ans = Math.max(ans, curLen);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(longestConsecutive(nums));
    }
}
