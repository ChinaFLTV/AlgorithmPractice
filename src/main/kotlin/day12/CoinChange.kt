package day12

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/2 下午 10:41:05
 * @version 1.0.0
 * @description 零钱兑换
 * @filename CoinChange.kt
 *
 */

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。*/

class Solution {


    fun coinChange(coins: IntArray, amount: Int): Int {

        val dp = Array(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0

        coins.sort()

        for (i in 1..amount) {

            for (j in coins.indices) {

                if (i < coins[j]) {

                    if (j == 0) {

                        dp[i] = -1

                    }
                    break

                } else if (i == coins[j]) {

                    dp[i] = 1
                    break

                } else {

                    if (dp[i - coins[j]] != -1) {

                        dp[i] = minOf(dp[i], 1 + dp[i - coins[j]])

                    }

                }

            }

            if (dp[i] == Int.MAX_VALUE) {

                dp[i] = -1

            }

        }

        return dp[amount]

    }


}