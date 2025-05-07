package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);
        int ans = 0;

        for (int right = 0; right <= n; right++) {
            int h = right < n ? heights[right] : -1;
            while (stk.size() > 1 && h <= heights[stk.peek()]) {
                int i = stk.pop();
                int left = stk.peek();
                ans = Math.max(ans, heights[i] * (right - left - 1));
            }
            stk.push(right);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        LargestRectangle solution = new LargestRectangle();
        System.out.println(solution.largestRectangleArea(nums));
    }
}
