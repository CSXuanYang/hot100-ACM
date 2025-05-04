package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(ans, path, 0, 0, candidates, target);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> path, int index, int curSum, int[] candidates, int target) {
        if (curSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length) {
            return;
        }

        // 不选择
        backtrack(ans, path, index + 1, curSum, candidates, target);

        // 选择
        if (curSum + candidates[index] <= target) {
            path.add(candidates[index]);
            backtrack(ans, path, index, curSum + candidates[index], candidates, target);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int target = sc.nextInt();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        CombinationSum solution = new CombinationSum();
        System.out.println(solution.combinationSum(nums, target));
    }
}
