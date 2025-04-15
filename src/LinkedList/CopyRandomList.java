package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class CopyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;
        Node() {}
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 把每个节点复制一份链接在原节点的后边
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node nxt = cur.next;
            cur.next = new Node(cur.val, nxt, null);
        }
        // 链接random,复制节点的random就是原节点的random的next
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        // 分离链表
        Node newHead = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        Node head = new Node(nums[0]);
        Node cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }

        Node newHead = copyRandomList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
