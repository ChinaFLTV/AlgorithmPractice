package day19

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/9 下午 10:38:36
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

            return if (matrix[0].contains('1')) 1 else 0

        }

        val dp = Array(matrix.size + 1) {

            IntArray(matrix[0].size + 1) { 0 }

        }

        for (x in 1..matrix[0].size) {

            dp[1][x] = matrix[0][x - 1].code - '0'.code

        }

        for (y in 2..matrix.size) {

            dp[y][1] = matrix[y - 1][0].code - '0'.code

        }

        for (y in 1..matrix.size) {

            for (x in 1..matrix[0].size) {

                if (matrix[y - 1][x - 1] == '1') {

                    dp[y][x] = minOf(dp[y - 1][x], dp[y - 1][x - 1], dp[y][x - 1]) + 1

                }

            }

        }

        return dp[matrix.size][matrix[0].size]

    }


}