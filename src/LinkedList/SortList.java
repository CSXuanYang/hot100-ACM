package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点，拆分链表
        ListNode mid = findMiddle(head);
        ListNode second = mid.next;
        mid.next = null;
        // 递归排序
        ListNode first = sortList1(head);
        second = sortList1(second);
        // 合并排序后的链表
        return merge(first, second);
    }

    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public static ListNode sortList2(ListNode head) {
        // 获取链表长度
        int len = getListLen(head);
        ListNode dummy = new ListNode(0, head);

        // step = 1，逐渐增大
        for (int step = 1; step < len; step *= 2) {
            ListNode cur = dummy.next;
            ListNode tail = dummy;

            // 分割链表
            ListNode head1 = cur;
            ListNode head2 = splitList(cur, step);
            cur = head2;

            // 合并链表
            tail.next = merge(head1, head2);

            // tail移动到合并好的末尾
            while (tail.next != null) {
                tail = tail.next;
            }
        }

        return dummy.next;
    }

    public static int getListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode splitList(ListNode head, int size) {
        ListNode cur = head;
        for (int i = 1; i < size && cur != null; i++) {
            cur = cur.next;
        }
        ListNode second = cur.next;
        cur.next = null;
        return second;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        head = sortList2(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
