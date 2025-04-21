package BinaryTree;

import java.util.*;

public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix,0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curSum, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        curSum += root.val;

        ans = prefix.getOrDefault(curSum - targetSum, 0);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        ans += dfs(root.left, prefix, curSum, targetSum);
        ans += dfs(root.right, prefix, curSum, targetSum);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) - 1);

        return ans;
    }

    public TreeNode buildTree(String[] nodes) {
        int n = nodes.length;
        if (n == 0 || "null".equals(nodes[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            TreeNode cur = queue.poll();
            if (!"null".equals(nodes[i])) {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(cur.left);
            }
            i++;

            if (i < n && !"null".equals(nodes[i])) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] nodes = s.split(",");
        int targetSum = sc.nextInt();
        PathSumIII solution = new PathSumIII();
        TreeNode root = solution.buildTree(nodes);
        System.out.println(solution.pathSum(root, targetSum));
    }
}
