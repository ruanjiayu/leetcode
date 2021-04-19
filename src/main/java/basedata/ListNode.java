package basedata;

/**
 * @Description: 单向列表节点
 * @Author: Summer
 * @DateTime: 2021/4/14 2:26 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}