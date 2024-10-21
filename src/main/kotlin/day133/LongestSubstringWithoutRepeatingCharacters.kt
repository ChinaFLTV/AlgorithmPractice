package day133

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/21 PM 3:13:32
 * @version 1.0.0
 * @description 无重复字符的最长子串
 * @filename LongestSubstringWithoutRepeatingCharacters.kt
 *
 */

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长
子串
的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成*/

class Solution {


    fun lengthOfLongestSubstring(s: String): Int {

        if (s.length <= 1)
            return s.length

        val map = mutableMapOf<Char, Int>()
        var head = 0
        var maxLen = Int.MIN_VALUE

        for ((i, c) in s.toCharArray().withIndex()) {

            if (map.containsKey(c)) {

                val newHeadPrevIdx = map[c]!!

                for (j in head..newHeadPrevIdx) {

                    map.remove(s[j])

                }

                map[c] = i
                head = newHeadPrevIdx + 1

            } else {

                map[c] = i

            }

            maxLen = max(maxLen, map.size)

        }

        return maxLen

    }


}