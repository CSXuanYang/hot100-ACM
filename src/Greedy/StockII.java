package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class StockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - prices[i - 1];
            ans += Math.max(profit, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] prices = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        StockII solution = new StockII();
        System.out.print(solution.maxProfit(prices));
    }
}
