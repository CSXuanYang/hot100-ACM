package DoublePointer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int preMax = 0, sufMax = 0;
        int ans = 0;

        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }

        return ans;
    }

    public int trap2(int[] height) {
        int n = height.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;

        for (int right = 0; right < n; right++) {
            while (!stk.isEmpty() && height[right] > height[stk.peek()]) {
                int bottom = stk.pop();
                // 前面没有柱子，无法接水
                if (stk.isEmpty()) {
                    break;
                }
                int left = stk.peek();
                int h = Math.min(height[left], height[right]) - height[bottom];
                ans += h * (right - left - 1);
            }
            stk.push(right);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] height = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println("双指针：" + solution.trap(height));
        System.out.println("单调栈：" + solution.trap2(height));
        sc.close();
    }
}
