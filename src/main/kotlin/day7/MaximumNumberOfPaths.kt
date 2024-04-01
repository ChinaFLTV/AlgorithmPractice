package day7

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/3/28 下午 10:44:02
 * @description 最多路径数(优化空间版)
 * @filename MaximumNumberOfPaths.java
 */


fun uniquePaths(m: Int, n: Int): Int {

    if (m <= 0 || n <= 0) {

        return 0

    }

    val dp = Array(m) { 1 }
    dp[0] = 0

    for (y in 1..<n) {

        dp[0] = 1
        for (x in 1..<m) {

            dp[x] = dp[x - 1] + dp[x]

        }

    }

    println(dp.contentToString())
    return dp[m - 1]

}


fun main() {

    println(uniquePaths(4, 4))

}