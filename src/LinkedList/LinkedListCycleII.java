package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class LinkedListCycleII {
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

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
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

        cur.next = cycleNode;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int pos = sc.nextInt();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode head = solution.buildList(nums, pos);
        ListNode node = solution.detectCycle(head);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("null");
        }
    }
}
