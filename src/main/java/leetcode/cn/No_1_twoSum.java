package leetcode.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author: Summer
 * @DateTime: 2021/4/14 2:24 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_1_twoSum {

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 1. 创建一个map。key为对应的值，value为对应的坐标
     * 2. 循环数组，判断数组内是否符合对应的值。通过map.containsKey方法来判断是否含有对应的值。
     * - 存在的情况下，直接返回
     * - 不符合情况下，将值放入map，因为在循环数组，后期可能会使用到值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
}
