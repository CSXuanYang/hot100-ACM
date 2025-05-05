package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuffer(), n, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuffer sb, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }

        // 选择左括号
        if (left > 0) {
            sb.append('(');
            backtrack(ans, sb,left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        // 选择右括号
        if (right > left) {
            sb.append(')');
            backtrack(ans, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GenerateParentheses solution = new GenerateParentheses();
        System.out.println(solution.generateParenthesis(n));
    }
}
