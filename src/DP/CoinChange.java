package DP;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 定义状态
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 枚举硬币
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int amount = sc.nextInt();
        int[] coins = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        CoinChange solution = new CoinChange();
        System.out.println(solution.coinChange(coins, amount));
        sc.close();
    }
}
