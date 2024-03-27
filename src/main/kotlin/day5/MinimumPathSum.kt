package day5

import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/26 下午 7:34:45
 * @version 1.0.0
 * @description 最小路径和
 * @filename MinimumPathSum.kt
 *
 */

/*给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。*/


class Solution1 {

    fun minPathSum(grid: Array<IntArray>): Int {

        val dp: Array<IntArray> = Array(grid.size) {

            IntArray(grid[0].size) { 0 }

        }

        dp[0][0] = grid[0][0]
        for (x in 1..<grid[0].size) {

            dp[0][x] = dp[0][x - 1] + grid[0][x]

        }
        for (y in 1..<grid.size) {

            dp[y][0] = dp[y - 1][0] + grid[y][0]

        }

        for (x in 1..<grid[0].size) {

            for (y in 1..<grid.size) {

                val cost1 = dp[y - 1][x] + grid[y][x]
                val cost2 = dp[y][x - 1] + grid[y][x]
                dp[y][x] = min(cost1, cost2)

            }

        }


        return dp[dp.size - 1][dp[0].size - 1]


    }

}


fun main() {

    val grid: Array<IntArray> = arrayOf(

        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)

    )


    println(Solution1().minPathSum(grid))

}
