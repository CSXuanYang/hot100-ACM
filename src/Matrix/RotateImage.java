package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
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
        int n = rows.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nums[j];
            }
        }
        RotateImage solution = new RotateImage();
        solution.rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
