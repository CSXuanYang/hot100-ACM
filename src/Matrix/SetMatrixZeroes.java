package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        // 标记变量
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
            }
        }
        // 初始化第一行和第一列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 矩阵置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        s = s.replaceAll("\\[\\[", "")
                .replaceAll("]]", "");
        String[] rows = s.split("],\\[");
        int rowCount = rows.length;
        int colCount = rows[0].split(",").length;
        int[][] matrix = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            int[] nums = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < colCount; j++) {
                matrix[i][j] = nums[j];
            }
        }
        SetMatrixZeroes solution = new SetMatrixZeroes();
        solution.setZeroes(matrix);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
