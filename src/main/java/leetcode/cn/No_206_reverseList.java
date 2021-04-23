package leetcode.cn;


import basedata.ListNode;
import org.junit.Test;
import util.PrintUtils;

/**
 * @Description: 链表反转
 * @Author: fan
 * @DateTime: 2021/4/15 10:11 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_206_reverseList {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
        nnn.next = nnnn;
        nn.next = nnn;
        n.next = nn;
        head.next = n;

        ListNode reverseNode = reverseList(head);
        PrintUtils.print(reverseNode);
    }


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 1. 先获取下一个节点
            ListNode next = curr.next;
            // 2. 将当前指针的后置节点设置为前一个
            curr.next = prev;
            // 3. 前一个节点设置成当前指针
            prev = curr;
            // 4. 当前节点向前移动
            curr = next;
        }
        return prev;
    }


    /**
     * 递归解决链表反转
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        // 此处的作用是形成一个环，即形成 1->2—>3->4->5->4的环
        head.next.next = head;
        // 即变成 1->2->3->4->null, 5->4->null;
        head.next = null;
        return newHead;
    }
}
