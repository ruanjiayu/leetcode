package util;

import java.util.Arrays;

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
}
