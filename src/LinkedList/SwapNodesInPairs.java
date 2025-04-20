package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode left = head;
        while (left != null && left.next != null) {
            ListNode right = left.next;
            ListNode nxt = right.next;
            pre.next = right;
            right.next = left;
            left.next = nxt;

            pre = left;
            left = nxt;
        }
        return dummy.next;
    }

    public ListNode buildList(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode head = solution.buildList(nums);
        head = solution.swapPairs(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
