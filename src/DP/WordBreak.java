package DP;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 定义状态
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // 用集合优化时间
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        // 枚举长度
        for (int i = 1; i <= n; i++) {
            // 枚举切分位置
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String words = sc.nextLine();
        List<String> wordDict = Arrays.stream(words.split(",")).toList();
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
