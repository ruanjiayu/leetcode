package leetcode.cn;

import util.Utils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 无重复字符的最长子串
 * @Author: Summer
 * @DateTime: 2021/5/27 3:02 下午
 * @Version: 0.0.1-SNAPSHOT
 */

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

public class No_3_lengthOfLongestSubstring {

    public static void main(String[] args) {
//        String str = Utils.generStr('a', 'z', 10);
        String str = "bbbbbb";
        System.out.println(lengthOfLongestSubstring_v2(str));
    }


    public static int lengthOfLongestSubstring_v2(String str) {
        // 存储对应字符
        HashSet<Character> hashSet = new HashSet<>();

        int maxLength = 0;
        int length = 0;
        int left = 0;
        int right = 0;

        for (; right < str.length(); right++) {
            char rightValue = str.charAt(right);
            // 字符检测不存在(则直接操作)
            if (!hashSet.contains(rightValue)) {
                // 存储字符
                hashSet.add(rightValue);
                length = right - left + 1;
                maxLength = Math.max(maxLength, length);
            }
            // 存在相同字符
            else {
                do {
                    char leftValue = str.charAt(left);
                    // 存在则移动左指针
                    hashSet.remove(leftValue);
                    left++;
                } while (hashSet.contains(rightValue));
                // 右边指针重新移动
                right--;
            }

        }

        return maxLength;
    }


    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_v3(String s) {
        // 存储对应字符的位置
        HashMap<Character, Integer> map = new HashMap<>();

        // max 最大值，start 开始的位置
        int max = 0, start = 0;

        for (int pointer = 0; pointer < s.length(); pointer++) {

            // 获取对应的位置的字符
            char ch = s.charAt(pointer);

            // 判断map中是否存在相同字符
            if (map.containsKey(ch)) {
                // 重新获得开始的位置
                start = Math.max(map.get(ch) + 1, start);
            }

            // 获取最大值
            max = Math.max(max, pointer - start + 1);

            // 把对应的位置存放
            map.put(ch, pointer);
        }

        return max;
    }
}
