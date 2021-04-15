package leetcode.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: 最接近的三数之和
 * @Author: Summer
 * @DateTime: 2021/4/14 7:55 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_16_threeSumClosest {

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 2};
        System.out.println(threeSumClosest(nums, -1));

    }


    /**
     * 1. 获取基准值b，首先采用获取前三个数字
     * 2. 采用左右指针的思路,将三数字之和a于目标值进行比较获取偏移量，将基准值调整为偏移量小的三数之和
     *  - 目标值小于a,将右指针向前移动
     *  - 目标值大于a,将左指着向后移动
     *  - 等于目标值，那么就直接返回
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("数据出现异常");
        }

        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length - 2; ++first) {
            int left = first + 1, right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[first] + nums[left] + nums[right];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (target < threeSum) {
                    right--;
                } else if (target > threeSum){
                    left++;
                } else {
                    return target;
                }
            }

        }

        return closestNum;
    }

}
