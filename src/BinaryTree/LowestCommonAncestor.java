package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LowestCommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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

            if (!"null".equals(nodes[i])) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    private TreeNode findNode(TreeNode node, int val) {  //本题由于p，q是作为节点输入，所以要写这么一个函数
        if(node == null || node.val == val)                     //可以根据传入的树根节点和值，来找到对应的节点
            return node;
        TreeNode left = findNode(node.left, val);
        TreeNode right = findNode(node.right, val);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        String[] nodes = s.split(",");
        LowestCommonAncestor solution = new LowestCommonAncestor();
        TreeNode root = solution.buildTree(nodes);
        TreeNode p = solution.findNode(root, num1);
        TreeNode q = solution.findNode(root, num2);
        TreeNode ans = solution.lowestCommonAncestor(root, p, q);
        if (ans != null) {
            System.out.println(ans.val);
        } else {
            System.out.println("null");
        }
    }
}
