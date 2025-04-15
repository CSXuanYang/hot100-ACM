package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // 双向链表结构
    public class DLinkedNode {
        int key;
        int value;
        DLinkedNode next;
        DLinkedNode prev;
        DLinkedNode() {}
        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 数据结构
    private int capacity;
    private DLinkedNode dummy;
    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        // 初始化哑节点
        dummy = new DLinkedNode();
        dummy.next = dummy;
        dummy.prev = dummy;
        // 初始化容量
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode node = getNode(key);
        if (node != null) {
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = getNode(key);
        // 存在，更新值
        if (node != null) {
            node.value = value;
        } else {
            // 不存在，new一个
            node = new DLinkedNode(key, value);
            pushFront(node);
            cache.put(key, node);
            // 如果超过容量，需要删除
            if (cache.size() > capacity) {
                cache.remove(dummy.prev.key);
                remove(dummy.prev);
            }
        }
    }

    private DLinkedNode getNode(int key) {
        // 判断是否存在，若存在，取出，放在最前面
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            remove(node);
            pushFront(node);
            return node;
        } else {
            return null;
        }
    }

    // 取出
    private void remove(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    // 放在最前面
    private void pushFront(DLinkedNode node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
    }
}
