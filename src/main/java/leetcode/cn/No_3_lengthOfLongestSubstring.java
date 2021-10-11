package leetcode.cn;

import util.Utils;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Summer
 * @DateTime: 2021/5/27 3:02 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_3_lengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = Utils.generStr('a', 'z', 10);
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 存储对应字符的位置
        HashMap<Character, Integer> map = new HashMap<>();

        // max 最大值，start 开始的位置
        int max = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {

            // 获取对应的位置的字符
            char ch = s.charAt(end);

            // 判断map中是否存在相同字符
            if (map.containsKey(ch)){
                // 重新获得开始的位置
                start = Math.max(map.get(ch)+1,start);
            }

            // 获取最大值
            max = Math.max(max,end - start + 1);

            // 把对应的位置存放
            map.put(ch,end);
        }

        return max;
    }
}
