package leetcode.cn;

import util.PrintUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Author: Summer
 * @DateTime: 2021/4/27 5:59 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_384_resetShuffleArray {

    int[] oriArrs = null;
    int[] curArrs = null;
    Random random = null;


    public No_384_resetShuffleArray(int[] nums) {
        this.oriArrs = nums;
        this.curArrs = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        this.curArrs = Arrays.copyOf(oriArrs, oriArrs.length);
        return curArrs;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < curArrs.length; i++) {
            int swapIndex = random.nextInt(curArrs.length);
            swap(i, swapIndex);
        }

        return curArrs;
    }

    void swap(int i, int j) {
        int tmp = curArrs[i];
        curArrs[i] = curArrs[j];
        curArrs[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        No_384_resetShuffleArray array = new No_384_resetShuffleArray(nums);
        PrintUtils.print(array.shuffle());
        PrintUtils.print(array.reset());
    }
}
