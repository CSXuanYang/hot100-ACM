package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < m; right++) {
            int ch = s.charAt(right) - 'a';
            cnt[ch]--;
            while (cnt[ch] < 0) {
                cnt[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == n) {
                ans.add(left);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(findAnagrams(s, p));
    }
}
