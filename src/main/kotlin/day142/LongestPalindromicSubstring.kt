package day142

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/4 PM 3:41:07
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

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/reedfan/">reedfan</a>
     * @date 2024/11/4 PM 3:42:15
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/longest-palindromic-substring/solutions/63641/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/">中心扩散法和动态规划</a>
     * @filename LongestPalindromicSubstring.kt
     *
     */
    fun longestPalindrome(s: String): String {

        if (s.length <= 1)
            return s

        val dp = Array(s.length) {

            Array(s.length) { false }

        }

        var maxLen = 1
        var left = 0
        var right = 0

        for (r in 1..<s.length) {

            for (l in 0..<r) {

                if (s[l] == s[r] && ((r - l - 1) <= 1 || dp[l + 1][r - 1])) {

                    dp[l][r] = true
                    if (r - l + 1 > maxLen) {

                        maxLen = r - l + 1
                        left = l
                        right = r

                    }

                }

            }

        }

        return s.substring(left, right + 1)

    }


}