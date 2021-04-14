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


    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("数据出现异常");
        }

        Arrays.sort(nums);
        int result = 200000;
        for (int i = 0; i < nums.length - 1; ++i) {
            int left = i + 1, right = nums.length - 1;
            int tem = target - nums[i];
            while (left < right) {
                int near = tem - nums[left] - nums[right];
                if (near == 0) {
                    return nums[i] + nums[left] + nums[right];
                } else {
                    int a = Math.abs(near);
                    int b = Math.abs(result);
                    if (a < b) {
                        result = near;
                    }
                    if (near < 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

        }

        return target - result;
    }

}
