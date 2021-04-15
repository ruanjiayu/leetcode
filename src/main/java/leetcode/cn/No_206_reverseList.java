package leetcode.cn;


import basedata.ListNode;

/**
 * @Description: 链表反转
 * @Author: fan
 * @DateTime: 2021/4/15 10:11 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_206_reverseList {


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 1. 先获取下一个节点
            ListNode next = curr.next;
            // 2. 切换链接
            curr.next = prev;
            // 3. 存值操作，并不进行指针操作
            prev = curr;
            // 4. 重新获取新的节点
            curr = next;
        }
        return prev;
    }
}
