package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SymmetricTree {
    public static class TreeNode{
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

    // 判断左右子树值是否相等，以及左子树的左子树是否等于右子树的右子树，以及左子树的右子树是否等于右子树的左子树
    public static Boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private static Boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

    // 广度优先
    public static Boolean isSymmetricIter(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();

            if (u == null && v == null) {
                continue;
            }

            if (u == null || v == null || u.val != v.val) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
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
        System.out.println("递归：" + isSymmetric(root));
        System.out.println("迭代：" + isSymmetricIter(root));
    }
}
