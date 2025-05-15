package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int target = sc.nextInt();
        sc.close();
        s = s.replaceAll("\\[\\[", "")
                .replaceAll("]]", "");
        String[] rows = s.split("],\\[");
        int m = rows.length;
        int n = rows[0].split(",").length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] nums = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nums[j];
            }
        }
        Search2DMatrixII solution = new Search2DMatrixII();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
