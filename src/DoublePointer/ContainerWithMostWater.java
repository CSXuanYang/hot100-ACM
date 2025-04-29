package DoublePointer;

import java.util.Arrays;
import java.util.Scanner;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] height = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(height));
        sc.close();
    }
}
