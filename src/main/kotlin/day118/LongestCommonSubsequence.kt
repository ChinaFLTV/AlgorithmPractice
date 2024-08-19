package day118

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/19 PM 2:52:06
 * @version 1.0.0
 * @description 最长公共子序列
 * @filename LongestCommonSubsequence.kt
 *
 */

/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。



示例 1：

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。
示例 2：

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。
示例 3：

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。


提示：

1 <= text1.length, text2.length <= 1000
text1 和 text2 仅由小写英文字符组成。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/leetcode-solution/">力扣官方题解</a>
     * @date 2024/8/19 PM 3:14:20
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/longest-common-subsequence/solutions/696763/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/">最长公共子序列</a>
     * @filename LongestCommonSubsequence.kt
     *
     */
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        val n = text1.length
        val m = text2.length

        val dp = Array(n + 1) {

            IntArray(m + 1) { 0 }

        }

        for (i in 1..n) {

            for (j in 1..m) {

                if (text1[i - 1] == text2[j - 1]) {

                    dp[i][j] = dp[i - 1][j - 1] + 1

                } else {

                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

                }

            }

        }

        return dp[n][m]

    }


}