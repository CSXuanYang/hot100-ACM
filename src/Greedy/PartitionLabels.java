package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        // 记录结束位置
        int[] endPos = new int[26];
        for (int i = 0; i < n; i++) {
            endPos[s.charAt(i) - 'a'] = i;
        }

        // 遍历
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, endPos[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        PartitionLabels solution = new PartitionLabels();
        System.out.println(solution.partitionLabels(s));
    }
}
