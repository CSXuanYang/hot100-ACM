package SlidingWindow;

import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[128];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            hash[c]++;
            while (hash[c] > 1) {
                hash[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }
}
