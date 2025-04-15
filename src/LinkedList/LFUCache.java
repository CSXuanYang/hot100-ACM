package LinkedList;

import javax.crypto.KEM;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LFUCache {
    public class DLinkedNode {
        int key;
        int value;
        int freq = 1;
        DLinkedNode next;
        DLinkedNode prev;
        DLinkedNode() {}
        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 数据结构
    int capacity;
    Map<Integer, DLinkedNode> keyToNode = new HashMap<>();
    Map<Integer, DLinkedNode> freqToDummy = new HashMap<>();
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode node = getNode(key);
        if (node != null) {
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = getNode(key);
        // 存在则更新
        if (node != null) {
            node.value = value;
            return;
        }
        // 不存在判断容量
        if (keyToNode.size() == capacity) {
            // 移出频率最小的
            DLinkedNode dummy = freqToDummy.get(minFreq);
            DLinkedNode minNode = dummy.prev;
            keyToNode.remove(minNode.key);
            remove(minNode);
            // 移出空链表
            if (dummy.prev == dummy) {
                freqToDummy.remove(minFreq);
            }
        }
        // 加入节点
        node = new DLinkedNode(key, value);
        keyToNode.put(key, node);
        pushFront(1, node);
        minFreq = 1;
    }

    // 创建新链表
    private DLinkedNode newList() {
        DLinkedNode dummy = new DLinkedNode(0, 0);
        dummy.next = dummy;
        dummy.prev = dummy;
        return dummy;
    }

    // 删除结点
    private void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 放到最前面
    private void pushFront(int freq, DLinkedNode node) {
        // 获取指定频率的链表哑节点
        DLinkedNode dummy = freqToDummy.computeIfAbsent(freq, k -> newList());
        // 放在链表最前面
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    // 获取节点
    private DLinkedNode getNode(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }
        DLinkedNode node = keyToNode.get(key);
        remove(node);

        DLinkedNode dummy = freqToDummy.get(node.freq);
        if (dummy.prev == dummy) {
            freqToDummy.remove(node.freq);
            // 更新最小频率
            if (minFreq == node.freq) {
                minFreq++;
            }
        }

        pushFront(++node.freq, node);
        return node;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(2));
        lfu.put(3, 3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4, 4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }
}
