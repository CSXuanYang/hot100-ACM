package BinaryTree;

import java.util.*;

public class ConstructBinaryTree {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(preorder, inMap, 0, n, 0, n);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> inMap, int preL, int preR, int inL, int inR) {
        if (preL == preR) {
            return null;
        }

        int leftSize = inMap.get(preorder[preL]) - inL;
        TreeNode left = dfs(preorder, inMap, preL + 1, preL + 1 + leftSize, inL, inL + leftSize);
        TreeNode right = dfs(preorder, inMap, preL + 1 + leftSize, preR, inL + leftSize + 1, inR);

        return new TreeNode(preorder[preL], left, right);
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
                System.out.print("null ");
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
        int[] preorder = Arrays.stream(s1.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] inorder = Arrays.stream(s2.split(",")).mapToInt(Integer::parseInt).toArray();
        ConstructBinaryTree solution = new ConstructBinaryTree();
        TreeNode root = solution.buildTree(preorder, inorder);
        solution.printTree(root);
    }
}
