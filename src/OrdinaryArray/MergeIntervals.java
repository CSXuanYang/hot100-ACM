package OrdinaryArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // 按起始排序
        Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));

        // 遍历区间，如果当前起始小于等于上一个区间的结束，则合并两区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int last[] = res.get(res.size()-1);
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }

        // 返回结果
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
