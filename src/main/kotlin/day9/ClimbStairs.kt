package day9

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/30 下午 10:27:12
 * @version 1.0.0
 * @description 爬楼梯
 * @filename ClimbStairs.kt
 *
 */


/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*/

class Solution1 {


    fun climbStairs(n: Int): Int {

        if (n <= 2) {

            return n

        }

        val dp = Array(n + 1) { 0 }
        dp[0] = 0
        dp[1] = 1
        dp[2] = 2

        for (i in 3..n) {

            dp[i] = dp[i - 2] * 1 + dp[i - 1] * 1

        }

        return dp[n]

    }


}