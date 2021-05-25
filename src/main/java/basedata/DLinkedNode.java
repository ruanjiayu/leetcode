package basedata;

/**
 * @Description: 双向链表
 * @Author: Summer
 * @DateTime: 2021/5/25 2:07 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class DLinkedNode {

    public int key;

    public int value;

    public DLinkedNode prev;

    public DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return "DLinkedNode{" +
                "key=" + key +
                ", value=" + value +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
