package handle;

import basedata.DLinkedNode;

/**
 * @Description: 双向链表操作类
 * @Author: Summer
 * @DateTime: 2021/5/25 2:21 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class DLinkedHandle {

    public DLinkedNode head;

    public DLinkedNode tail;

    public DLinkedHandle() {
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }


    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public DLinkedNode removeTail() {
        DLinkedNode result = tail.prev;
        removeNode(result);
        return result;
    }

}
