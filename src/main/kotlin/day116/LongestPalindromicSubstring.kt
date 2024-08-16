package day116

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/16 PM 12:33:49
 * @version 1.0.0
 * @description 最长回文子串
 * @filename LongestPalindromicSubstring.kt
 *
 */

/*
给你一个字符串 s，找到 s 中最长的
回文

子串
。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母组成*/

class Solution2 {


    /**
     *
     * @author <a href="https://leetcode.cn/u/reedfan/">reedfan</a>
     * @date 2024/8/16 PM 12:43:53
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/longest-palindromic-substring/solutions/63641/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/">中心扩散法和动态规划</a>
     * @filename LongestPalindromicSubstring.kt
     *
     */
    fun longestPalindrome(s: String): String {

        val length = s.length
        if (length <= 1)
            return s

        val dp = Array(length) {

            BooleanArray(length) { false }

        }

        var maxLen = 1
        var maxLeft = 0
        var maxRight = 0

        for (right in 1..<length) {

            for (left in 0..<right) {

                if (s[left] == s[right] && (right - left <= 2 || dp[left + 1][right - 1])) {

                    dp[left][right] = true
                    if (right - left + 1 > maxLen) {

                        maxLen = right - left + 1
                        maxLeft = left
                        maxRight = right

                    }

                }

            }

        }

        return s.substring(maxLeft, maxRight + 1)

    }


}