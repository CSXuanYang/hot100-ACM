package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, ans, path, 0);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> path, int index) {
        // 递归结束
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选
        dfs(nums, ans, path, index + 1);

        // 选
        path.add(nums[index]);
        dfs(nums, ans, path, index + 1);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        Subsets solution = new Subsets();
        System.out.println(solution.subsets(nums));
    }
}
