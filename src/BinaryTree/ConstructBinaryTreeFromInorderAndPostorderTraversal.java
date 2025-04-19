package BinaryTree;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(inMap, postorder, 0, n, 0, n);
    }

    private TreeNode dfs(Map<Integer, Integer> inMap, int[] postorder, int inL, int inR, int postL, int postR) {
        if (postL == postR) {
            return  null;
        }

        int leftSize = inMap.get(postorder[postR-1]) - inL;
        TreeNode left = dfs(inMap, postorder, inL, inL + leftSize, postL, postL + leftSize);
        TreeNode right = dfs(inMap, postorder, inL + leftSize + 1, inR, postL + leftSize, postR - 1);
        return new TreeNode(postorder[postR - 1], left, right);
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                System.out.println("null");
            } else {
                System.out.print(cur.val + " ");
                if (cur.left == null && cur.right == null) {
                    continue;
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] inorder = Arrays.stream(s1.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] postorder = Arrays.stream(s2.split(",")).mapToInt(Integer::parseInt).toArray();
        ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode root = solution.buildTree(inorder, postorder);
        solution.printTree(root);
    }
}
