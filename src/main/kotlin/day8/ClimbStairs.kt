package day8

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/29 下午 10:37:43
 * @version 1.0.0
 * @description 爬楼梯
 * @filename ClimbStairs.kt
 *
 */


/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*/


class Solution {


    fun climbStairs(n: Int): Int {

        if (n <= 2) {

            return n

        }

        val dp = Array(n + 1) { 0 }
        dp[0] = 0
        dp[1] = 1

        for (i in 3..n) {

            dp[n] = dp[n - 2] + dp[n - 1]

        }

        return dp[n]

    }


}