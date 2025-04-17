package BinaryTree;

import java.util.*;

public class ValidateBinarySearchTree {
    public static class TreeNode {
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

    public static boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }

    // 中序遍历迭代实现
    public static boolean isValidBSTInOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        long inorder = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }

        return true;
    }

    public static TreeNode buildTree(String[] nodes) {
        int n = nodes.length;
        if (n == 0 || nodes[0] == "null") {
            return  null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty() && i < n) {
            TreeNode cur = queue.poll();
            if (!"null".equals(nodes[i])) {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(cur.left);
            }
            i++;

            if (!"null".equals(nodes[i])) {
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
        System.out.println("递归:" + isValidBST(root));
        System.out.println("中序遍历:" + isValidBST(root));
    }
}
