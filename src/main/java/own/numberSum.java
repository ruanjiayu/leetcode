package own;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: n数字求和, 要求不重复。leetode相关题型为1、15、18
 * @Author: Summer
 * @DateTime: 2021/4/15 4:35 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class numberSum {

    @Test
    public void test() {
        int[] nums = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(nSum(nums, 24, 7));
    }

    /**
     * @param nums   数组
     * @param target 目标值
     * @param num    几个数字
     * @return
     */
    public List<List<Integer>> nSum(int[] nums, int target, int num) {// 总时间复杂度：O(n^3)
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < num) {
            return result;
        }

        // O(nlogn) 为了排除相同数据
        Arrays.sort(nums);

        nSum(nums, target, num, new ArrayList<>(), result, 0);
        return result;
    }

    /**
     * @param nums 数组
     * @param target 目标值
     * @param num 几个数字
     * @param tranList 临时存储的目标值
     * @param result 需要的目标值
     * @return
     */
    public List<List<Integer>> nSum(int[] nums, int target, int num, List<Integer> tranList, List<List<Integer>> result, int beforeBase) {
        if (num == 3) {
            for (int i = beforeBase; i < nums.length - 2; i++) {
                if (i > beforeBase && nums[i] == nums[i - 1]) {
                    continue; // 去掉重复情况
                }
                int temTarget = target - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    // 当符合条件的时候
                    if (nums[left] + nums[right] == temTarget) {
                        ArrayList<Integer> valList = new ArrayList<>();

                        valList.addAll(tranList);
                        valList.add(nums[i]);
                        valList.add(nums[left]);
                        valList.add(nums[right]);
                        result.add(valList);
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
        } else {
            int base = tranList.size();
            for (int i = beforeBase; i < nums.length - num + 1; i++) {

                int n = num - 1;

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 优化。数组内最小的数之和一定要小于target
                if (nums[i] + n * nums[i + 1] > target) {
                    continue;
                }
                // 优化。数组内最大的数之和一定要大于target
                if (nums[i] + n * nums[nums.length - 1] < target) {
                    continue;
                }

                int afterTarget = target - nums[i];

                tranList = tranList.subList(0, base);
                tranList.add(nums[i]);
                nSum(nums, afterTarget, n, tranList, result, i + 1);
            }
        }

        return result;
    }


}
