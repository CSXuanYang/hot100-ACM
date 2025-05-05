package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String dots = String.join("", Collections.nCopies(n, "."));
        for (int i = 0; i < n; i++) {
            board.add(dots);
        }
        dfs(ans, board, 0);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> board, int row) {
        int n = board.size();
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                String cur = board.get(row);
                board.set(row, cur.substring(0, col) + "Q" + cur.substring(col + 1));
                dfs(ans, board, row + 1);
                board.set(row, cur);
            }
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        NQueens solution = new NQueens();
        System.out.println(solution.solveNQueens(n));
    }
}
