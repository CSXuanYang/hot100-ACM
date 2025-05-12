package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] prices = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        Stock solution = new Stock();
        System.out.print(solution.maxProfit(prices));
    }
}
