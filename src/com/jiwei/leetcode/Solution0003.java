package com.jiwei.leetcode;

import java.util.HashMap;

/**
 * 无重复最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
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
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

public class Solution0003 {

    /**
     * 暴力求解
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int start = 0;
        int end = 1;
        int ans = 0;
        while (end < s.length()) {
            String substring = s.substring(start, end);
            char c = s.charAt(end);
            if (substring.indexOf(c) > -1) {
                ans = Math.max(ans, substring.length());
                start++;
                end = start + 1;
            } else {
                if (end == s.length() - 1) {
                    String substring1 = s.substring(start);
                    ans = Math.max(ans, substring1.length());
                }
                end++;
            }
        }
        return ans;
    }


    /**
     * 滑动窗口法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int start = 0;
        int end = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (start < s.length() && end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
            end++;
        }
        return ans;
    }


}
