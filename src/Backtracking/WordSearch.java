package Backtracking;

import java.util.Scanner;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        boolean res = dfs(board, word, visited, i - 1, j, index + 1) ||
                dfs(board, word, visited, i + 1, j, index + 1) ||
                dfs(board, word, visited, i, j - 1, index + 1) ||
                dfs(board, word, visited, i, j + 1, index +1);
        visited[i][j] = false;

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String word = sc.nextLine();
        sc.close();
        s = s.replaceAll("\\[\\[", "")
                .replaceAll("]]", "")
                .replaceAll("\"", "");
        String[] rows = s.split("],\\[");
        int m = rows.length;
        int n = rows[0].split(",").length;
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String[] cur = rows[i].split(",");
            for (int j = 0; j < n; j++) {
                board[i][j] = cur[j].charAt(0);
            }
        }

        WordSearch solution = new WordSearch();
        System.out.println(solution.exist(board, word));
    }
}
