package leetcode.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 三数之和为0
 * @Author: Summer
 * @DateTime: 2021/4/14 5:52 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_15_threeSum {

    @Test
    public void test() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    /**
     * 1. 先考虑边界值
     *      - 个数
     *      - null
     * 2. 排序操作(因为需要排除相同数据)
     * 3. 获取第一个元素a，那么可以断定后面2个元素之和一定等于a的相反数b
     * 4. 而要获取后面两个元素，可以采用左右指针，首尾便利数组来进行获取数据
     *      - 当两个数字大于b,将尾指针向头部靠近
     *      - 当两个数字小于b,将首指针向尾部靠近
     *      - 相等时，存储相关数据，并将首指针向后，尾巴指针向前再次循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ans;
        }

        // O(nlogn) 为了排除相同数据
        Arrays.sort(nums);

        // O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去掉重复情况
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 当符合条件的时候
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                // 当目标值小于两数之和时，将左指针向后移动
                else if (nums[left] + nums[right] < target) {
                    left++;
                }
                // 当目标大于两数之和时，将右指针向前移动
                // nums[left] + nums[right] > target
                else {
                    right--;
                }
            }
        }
        return ans;
    }
}
