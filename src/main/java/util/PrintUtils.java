package util;

import basedata.DLinkedNode;
import basedata.ListNode;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description: 打印信息
 * @Author: Summer
 * @DateTime: 2021/4/14 2:40 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class PrintUtils {
    /**
     * 打印二维数组
     *
     * @param nums
     */
    public static void print(int[][] nums) {
        for (int row = 0; row < nums.length; row++) {
            System.out.println(Arrays.toString(nums[row]));
        }
    }

    public static void print(char[] chars) {
        System.out.println(Arrays.toString(chars));
    }

    public static void print(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }

    /**
     * 打印一维数组
     *
     * @param nums
     */
    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static <T> void print(T[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void print(double[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void print(boolean[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void print(ListNode node) {
        if (Objects.nonNull(node)) {
            System.out.print(node.val + "->");
            print(node.next);
        } else {
            System.out.println("null");
        }
    }

    public static void print(DLinkedNode node) {
        if (Objects.nonNull(node)) {
            if (node.prev == null) {
                print(node.next);
                return;
            }
            if (node.next == null) {
                if (node.prev.prev == null) {
                    System.out.println("空的链表");
                }
                System.out.println("null");
                return;
            }
            System.out.print(node.value + "->");
            print(node.next);
        } else {
            System.out.println("null");
        }
    }
}
