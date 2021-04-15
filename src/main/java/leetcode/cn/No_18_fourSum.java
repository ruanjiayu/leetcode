package leetcode.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 四数字之和
 * @Author: Summer
 * @DateTime: 2021/4/15 11:44 上午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_18_fourSum {

    @Test
    public void test() {
        // {2, 2, 2, 2}
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(nums, -11));
    }


    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {// 总时间复杂度：O(n^3)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ans;
        }

        // O(nlogn) 为了排除相同数据
        Arrays.sort(nums);

        // O(n^3)
        for (int first = 0; first < nums.length - 3; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue; // 去掉重复情况
            }

            for (int i = first + 1; i < nums.length - 2; i++) {
                if (i > (first + 1) && nums[i] == nums[i - 1]) {
                    continue; // 去掉重复情况
                }
                int temTarget = target - nums[first] - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    // 当符合条件的时候
                    if (nums[left] + nums[right] == temTarget) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[first], nums[i], nums[left], nums[right])));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    // 当目标值小于两数之和时，将左指针向后移动
                    else if (nums[left] + nums[right] < temTarget) {
                        left++;
                    }
                    // 当目标大于两数之和时，将右指针向前移动
                    // nums[left] + nums[right] > temTarget
                    else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
