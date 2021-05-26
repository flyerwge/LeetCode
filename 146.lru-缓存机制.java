import java.util.HashMap;

import org.graalvm.compiler.graph.Node;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {
    class Node {
        int key;
        int value;
        Node preNode;
        Node nextNode;

        public Node() {
        };

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        };
    }

    private Node head, tail; // 伪头部和伪尾部节点
    HashMap<Integer, Node> LRUHash = new HashMap<>();
    int size = 0; // 记录缓存容量是否达到上限
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.nextNode = tail;
        tail.preNode = head;

    }

    public int get(int key) {
        Node node = LRUHash.get(key);
        if (node == null) {
            return -1;
        }

        moveNodeToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        Node isHashNode = LRUHash.get(key);
        if (isHashNode == null) {
            Node node = new Node(key, value);
            addToHead(node);
            LRUHash.put(key, node);
            size++;
            if (size > capacity) {
                Node tail = deleteTailNode();
                LRUHash.remove(tail.key);
                size--;
            }
        } else {
            // 如果关键字存在，变更其数据值
            isHashNode.value = value;
            moveNodeToHead(isHashNode);
        }

    }

    private void addToHead(Node node) {
        node.preNode = head;
        node.nextNode = head.nextNode;
        head.nextNode.preNode = node;
        head.nextNode = node;
    }

    private void removeNode(Node node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }

    private void moveNodeToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node deleteTailNode() {
        Node dtNode = tail.preNode;
        removeNode(dtNode);
        return dtNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
