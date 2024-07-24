package day106

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/24 21:08
 * @version 1.0.0
 * @description 最长回文子串
 * @filename LongestPalindromicSubstring.kt
 *
 */

/*
给你一个字符串 s，找到 s 中最长的回文子串。*/

class Solution2 {


    /**
     *
     * @author <a href="https://leetcode.cn/u/reedfan/">reedfan</a>
     * @date 2024/7/24 23:19
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/longest-palindromic-substring/solutions/63641/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/">中心扩散法和动态规划</a>
     * @filename LongestPalindromicSubstring.kt
     *
     */
    fun longestPalindrome(s: String): String {

        if (s.length <= 1)
            return s

        val dp = Array(s.length) {

            BooleanArray(s.length) { false }

        }

        var maxLen = 1
        var left = 0
        var right = 0

        for (l in s.length - 1 downTo 0) {

            for (r in l + 1..<s.length) {

                if (s[l] == s[r] && (r - l <= 2 || dp[l + 1][r - 1])) {

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


fun main() {

    println(Solution2().longestPalindrome("babad"))

}