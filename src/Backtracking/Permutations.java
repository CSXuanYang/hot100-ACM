package Backtracking;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            cur.add(nums[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, cur, 0);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> cur, int index) {
        if (index == cur.size()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < cur.size(); i++) {
            Collections.swap(cur, index, i);
            backtrack(ans, cur, index + 1);
            Collections.swap(cur, index, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        Permutations solution = new Permutations();
        List<List<Integer>> ans = solution.permute(nums);
        System.out.println(ans);
    }
}
