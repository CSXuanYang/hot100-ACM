package BinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SearchMatrix {
    public boolean searchMatrixZ(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            if (x < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
        int rowCount = rows.length;
        int colCount = rows[0].split(",").length;
        int[][] matrix = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            int[] nums = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < colCount; j++) {
                matrix[i][j] = nums[j];
            }
        }
        SearchMatrix solution = new SearchMatrix();
        System.out.println("z字形查找：" + solution.searchMatrixZ(matrix, target));
        System.out.println("二分查找：" + solution.searchMatrix(matrix, target));
    }
}
