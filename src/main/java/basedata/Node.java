package basedata;

/**
 * @Description: 节点
 * @Author: Summer
 * @DateTime: 2021/4/14 2:27 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int data) {
        this.val = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}