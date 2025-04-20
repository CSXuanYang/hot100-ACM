package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class LinkedListCycle {
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

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode buildList(int[] nums, int pos) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        ListNode cycleNode = null;
        if (pos == 0) {
            cycleNode = head;
        }

        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
            if (i == pos) {
                cycleNode = cur;
            }
        }

        if (pos != -1) {
            cur.next = cycleNode;
        }

        return head;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int pos = sc.nextInt();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        LinkedListCycle solution = new LinkedListCycle();
        ListNode head = solution.buildList(nums,pos);
        System.out.println(solution.hasCycle(head));
    }
}
