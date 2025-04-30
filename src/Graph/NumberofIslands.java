package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (!isValid(grid, row, col)) {
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    private boolean isValid(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public int numIslandsIter(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '2';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * n + j);

                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int r = id / n;
                        int c = id % n;
                        if (isValid(grid, r - 1, c) && grid[r-1][c] == '1') {
                            queue.offer((r - 1) * n + c);
                            grid[r-1][c] = '2';
                        }
                        if (isValid(grid, r + 1, c) && grid[r+1][c] == '1') {
                            queue.offer((r + 1) * n + c);
                            grid[r+1][c] = '2';
                        }
                        if (isValid(grid, r, c - 1) && grid[r][c - 1] == '1') {
                            queue.offer(r * n + c - 1);
                            grid[r][c-1] = '2';
                        }
                        if (isValid(grid, r, c + 1) && grid[r][c + 1] == '1') {
                            queue.offer(r * n + c + 1);
                            grid[r][c+1] = '2';
                        }
                    }
                }
            }
        }

        return ans;
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootY] < rank[rootX]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                --count;
            }
        }

        public int getCount() {
            return this.count;
        }
    }

    public int numIslandsUnion(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    if (isValid(grid, i - 1, j) && grid[i-1][j] == '1') {
                        uf.union(i * n + j, (i-1) * n + j);
                    }
                    if (isValid(grid, i + 1, j) && grid[i+1][j] == '1') {
                        uf.union(i * n + j, (i+1) * n + j);
                    }
                    if (isValid(grid, i, j - 1) && grid[i][j-1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (isValid(grid, i, j + 1) && grid[i][j+1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入二维字符数组（例如 [[\"1\",\"1\"],[\"0\",\"1\"]]）：");
        String input = sc.nextLine();
        sc.close();

        // 去掉外围的大括号和双引号
        input = input.replaceAll("\\[\\[", "")
                .replaceAll("]]", "")
                .replaceAll("\"", "");

        // 以 "],[" 分割每一行
        String[] rows = input.split("],\\[");

        int rowCount = rows.length;
        int colCount = rows[0].split(",").length; // 假设每行列数一致
        char[][] grid = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            String[] chars = rows[i].split(",");
            for (int j = 0; j < colCount; j++) {
                grid[i][j] = chars[j].charAt(0);
            }
        }

        NumberofIslands solution = new NumberofIslands();
        // System.out.println("递归：" + solution.numIslands(grid));
        // System.out.println("迭代：" + solution.numIslandsIter(grid));
        System.out.println("并查集：" + solution.numIslandsUnion(grid));
    }
}
