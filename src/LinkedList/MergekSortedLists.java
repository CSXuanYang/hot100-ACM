package LinkedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergekSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public static ListNode mergeKListHeap(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            pq.offer(node);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeSort(lists,0, lists.length - 1);
    }

    public static ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >> 1;
        return merge(mergeSort(lists, left, mid), mergeSort(lists, mid+1, right));
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            String s = sc.nextLine();
            String[] sp = s.split(",");
            lists[i] = new ListNode(Integer.parseInt(sp[0]));
            ListNode cur = lists[i];
            for (int j = 1; j < sp.length; j++) {
                cur.next = new ListNode(Integer.parseInt(sp[j]));
                cur = cur.next;
            }
        }

        //ListNode head = mergeKList(lists);
        ListNode head = mergeKListHeap(lists);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
