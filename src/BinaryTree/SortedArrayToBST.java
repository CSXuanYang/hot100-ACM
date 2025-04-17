package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SortedArrayToBST {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    private static TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }

        int mid = (left + right) >> 1;
        return new TreeNode(nums[mid], dfs(nums, left, mid), dfs(nums,mid + 1, right));
    }

    public static void printTree(TreeNode root) {
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
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        TreeNode root = sortedArrayToBST(nums);
        printTree(root);
    }
}
