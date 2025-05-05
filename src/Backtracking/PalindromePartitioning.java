package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(ans, path, s, 0);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> path, String s, int index) {
        int n = s.length();
        if (index == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 枚举子串结束的位置
        for (int j = index; j < n; j++) {
            if (isPalindrome(s, index, j)) {
                path.add(s.substring(index, j + 1));
                dfs(ans, path, s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        PalindromePartitioning solution = new PalindromePartitioning();
        System.out.println(solution.partition(s));
    }
}
