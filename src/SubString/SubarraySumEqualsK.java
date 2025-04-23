package SubString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans =0, prefix = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            if (hash.containsKey(prefix - k)) {
                ans += hash.get(prefix - k);
            }
            hash.put(prefix, hash.getOrDefault(prefix, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        System.out.println(solution.subarraySum(nums, k));
    }
}
