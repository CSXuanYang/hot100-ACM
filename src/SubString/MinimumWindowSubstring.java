package SubString;

import java.util.Scanner;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] cnt = new int[128];
        int ansLeft = -1, ansRight = m;
        int less = 0;
        // 初始化
        for (int i = 0; i < n; i++) {
            if (cnt[t.charAt(i)] == 0) {
                less++;
            }
            cnt[t.charAt(i)]++;
        }

        // 遍历s
        int left = 0;
        for (int right = 0; right < m; right++) {
            // 更新哈希表和less
            cnt[s.charAt(right)]--;
            if (cnt[s.charAt(right)] == 0) {
                less--;
            }
            // 如果涵盖，滑动左边界
            while (less == 0) {
                // 更新结果
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                // 更新哈希表和less
                cnt[s.charAt(left)]++;
                if (cnt[s.charAt(left)] > 0) {
                    less++;
                }
                left++;
            }
        }

        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow(s, t));
    }
}
