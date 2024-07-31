package day110

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/31 PM 5:22:51
 * @version 1.0.0
 * @description 无重复字符的最长子串
 * @filename LongestSubstringWithoutRepeatingCharacters.kt
 *
 */

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/ye-de-di-qi-jie/">凝视前方身后的距离</a>
     * @date 2024/7/31 PM 5:52:23
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/3982/hua-dong-chuang-kou-by-powcai/comments/475125">对java代码进行举例解释！</a>
     * @filename LongestSubstringWithoutRepeatingCharacters.kt
     *
     */
    fun lengthOfLongestSubstring(s: String): Int {

        if (s.length <= 1)
            return s.length

        val map = hashMapOf<Char, Int>()
        var maxLen = 0
        var left = 0

        for (i in s.indices) {

            if (map.containsKey(s[i])) {

                left = max(left, map[s[i]]!! + 1)

            }
            map[s[i]] = i
            maxLen = max(maxLen, i - left + 1)

        }

        return maxLen

    }


}