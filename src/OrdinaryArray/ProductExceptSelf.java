package OrdinaryArray;

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // 计算前缀积
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 计算后缀积
        int suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suf;
            suf *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        ProductExceptSelf solution = new ProductExceptSelf();
        int[] ans = solution.productExceptSelf(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
