package day6

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/27 下午 9:47:44
 * @version 1.0.0
 * @description 编辑距离
 * @filename EditDistance.kt
 *
 */

/*
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符*/


class Solution {


    fun minDistance(word1: String, word2: String): Int {

        val dp = Array(word1.length + 1) {

            IntArray(word2.length + 1) { 0 }

        }

        dp[0][0] = 0
        for (x in 1..<dp[0].size) {

            dp[0][x] = x

        }
        for (y in 1..<dp.size) {

            dp[y][0] = y

        }

        for (x in 1..<dp[0].size) {


            for (y in 1..<dp.size) {

                if (word1[y - 1] == word2[x - 1]) {

                    dp[y][x] = dp[y - 1][x - 1]

                } else {

                    dp[y][x] = minOf(dp[y][x - 1], dp[y - 1][x - 1], dp[y - 1][x]) + 1

                }

            }

        }

        return dp[word1.length][word2.length]

    }


}