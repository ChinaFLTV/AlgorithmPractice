package day7

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/28 下午 10:52:31
 * @version 1.0.0
 * @description 编辑距离(优化空间版)
 * @filename EditDistance.kt
 *
 */


fun minDistance(word1: String, word2: String): Int {

    val dp = Array(word2.length + 1) {

        it

    }

    var dpPrev: Int
    var dpTemp: Int


    for (y in 1..word1.length) {

        dpPrev = dp[0]
        dp[0] = y

        for (x in 1..<dp.size) {

            dpTemp = dp[x]

            if (word1[y - 1] == word2[x - 1]) {

                dp[x] = dpPrev

            } else {

                dp[x] = minOf(dp[x - 1], dpPrev, dp[x]) + 1

            }

            dpPrev = dpTemp

        }

    }

    return dp[word2.length]

}


fun main() {

    println(minDistance("abcd", "abcdefg"))

}