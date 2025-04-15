package LinkedList;

import java.util.*;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur =dummy;
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
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] split1 = s1.split(",");
        ListNode list1 = new ListNode(Integer.parseInt(split1[0]));
        ListNode l1 = list1;
        for (int i = 1; i < split1.length; i++) {
            l1.next = new ListNode(Integer.parseInt(split1[i]));
            l1 = l1.next;
        }
        String s2 = sc.nextLine();
        String[] split2 = s2.split(",");
        ListNode list2 = new ListNode(Integer.parseInt(split2[0]));
        ListNode l2 = list2;
        for (int i = 1; i < split2.length; i++) {
            l2.next = new ListNode(Integer.parseInt(split2[i]));
            l2 = l2.next;
        }

        ListNode head = mergeTwoLists(list1, list2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
