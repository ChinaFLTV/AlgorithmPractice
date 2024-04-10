package day20

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/10 下午 10:31:07
 * @version 1.0.0
 * @description 最大正方形
 * @filename MaximumSquare.kt
 *
 */

/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。*/


class Solution {


    fun maximalSquare(matrix: Array<CharArray>): Int {

        if (matrix.size == 1 || matrix[0].size == 1) {

            for (y in matrix.indices) {

                if (matrix[y].contains('1')) {

                    return 1

                }

            }

            return 0

        }

        val dp = Array(matrix.size + 1) {

            IntArray(matrix[0].size + 1) { 0 }

        }
        var maximum = 0

        for (x in 1..matrix[0].size) {

            dp[1][x] = matrix[0][x - 1].code - '0'.code
            maximum = max(maximum, dp[1][x])

        }

        for (y in 2..matrix.size) {

            dp[y][1] = matrix[y - 1][0].code - '0'.code
            maximum = max(maximum, dp[y][1])

        }

        for (y in 2..matrix.size) {

            for (x in 2..matrix[0].size) {

                if (matrix[y - 1][x - 1] == '1') {

                    dp[y][x] = minOf(dp[y][x - 1], dp[y - 1][x - 1], dp[y - 1][x]) + 1
                    maximum = max(maximum, dp[y][x])

                }

            }

        }

        return maximum * maximum

    }


}