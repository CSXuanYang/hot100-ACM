package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DiameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 返回最大深度
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = dfs(root.left);
        int maxRight = dfs(root.right);
        ans = Math.max(ans, maxLeft + maxRight);

        return Math.max(maxLeft, maxRight) + 1;
    }

    public static TreeNode buildTree(String[] nodes) {
        int n = nodes.length;
        if (n == 0 || nodes[0].equals("null")) {
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
        TreeNode root = buildTree(nodes);

        // 注意这里要创建实例来调用实例方法
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}
