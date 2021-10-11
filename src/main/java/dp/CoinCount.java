package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: 给定一定面值的硬币，凑出对应面值的最少个数
 * @Author: Summer
 * @DateTime: 2021/8/18 11:06 上午
 * @Version: 0.0.1-SNAPSHOT
 */
public class CoinCount {

    @Test
    public void test() {
        // 硬币面值
        int[] values = {2, 1};
        // 总值
        int total = 2;

        // , -2); // 备忘录，没有缓存的元素为-2
        int[] memo = new int[total + 1];
        Arrays.fill(memo, -2);

        // 其中0对应的结果也是0，首先存在备忘录中
        memo[0] = 0;

        // 求得最小的硬币数量，并输出结果
        System.out.println(getMinCountsHelper(total, values, memo));
    }



    int getMinCountsHelper(int total, int[] values, int[] memo) {
        int savedMinCount = memo[total];
        if (savedMinCount != -2) { return savedMinCount; }


        int valueLength = values.length;
        int minCount = Integer.MAX_VALUE;
        // 遍历所有面值
        for (int i = 0;  i < valueLength; i ++) {
            int currentValue = values[i];
            // 如果当前面值大于硬币总额，那么跳过
            if (currentValue > total) { continue; }

            // 使用当前面值，得到剩余硬币总额
            int rest = total - currentValue;
            int restCount = getMinCountsHelper(rest, values, memo);
            // 如果返回-1，说明组合不可信，跳过
            if (restCount == -1) { continue; }

            // 保留最小总额
            int totalCount = 1 + restCount;
            if (totalCount < minCount) { minCount = totalCount; }
        }

        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) {
            memo[total] = -1;
            return -1;
        }

        // 记录到备忘录
        memo[total] = minCount;
        // 返回最小硬币数量
        System.out.print("==" + minCount);
        return minCount;
    }


}
