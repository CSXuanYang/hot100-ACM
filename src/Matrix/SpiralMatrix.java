package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            // 向右走
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up += 1;
            if (up > down) {
                break;
            }
            // 向下走
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right -= 1;
            if (right < left) {
                break;
            }
            // 向左走
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            down -= 1;
            if (down < up) {
                break;
            }
            // 向上走
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            left += 1;
            if (left > right) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
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

        SpiralMatrix solution = new SpiralMatrix();
        System.out.println(solution.spiralOrder(matrix));
    }
}
