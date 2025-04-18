package BinaryTree;

import java.util.*;

public class KthSmallest {
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

    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || ans != -1) {
            return;
        }

        dfs(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public int kthSmallestIter(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int ans = 0;
        int count = 0;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            count++;
            if (count ==k) {
                return root.val;
            }
            root = root.right;
        }

        return -1;
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
        int k = sc.nextInt();

        KthSmallest solution = new KthSmallest();
        TreeNode root = solution.buildTree(nodes);
        System.out.println("递归中序遍历：" + solution.kthSmallest(root, k));
        System.out.println("迭代中序遍历：" + solution.kthSmallestIter(root, k));
    }
}
