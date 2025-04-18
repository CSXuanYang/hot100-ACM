package BinaryTree;

import LinkedList.DeleteDuplicatesII;

import java.util.*;

public class FlattenBinaryTree {
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

    // 先序遍历-迭代
    public void flattenPreOrderIter(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                arr.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        // 链接成链表
        for (int i = 1; i < arr.size(); i++) {
            TreeNode pre = arr.get(i - 1);
            TreeNode cur = arr.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    // 后续遍历-递归
    TreeNode pre = null;
    public void flattenPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenPostOrder(root.right);
        flattenPostOrder(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }

    // morris遍历
    public void flattenMorris(TreeNode root){
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树上最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 把右子树挂到左子树最右边
                pre.right = root.right;
                // 左子树移到右子树上
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    public void printLinkedList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] nodes = s.split(",");
        FlattenBinaryTree solution = new FlattenBinaryTree();
        TreeNode root = solution.buildTree(nodes);
        //solution.flattenPreOrderIter(root);
        //solution.flattenPostOrder(root);
        solution.flattenMorris(root);
        solution.printLinkedList(root);
    }
}
