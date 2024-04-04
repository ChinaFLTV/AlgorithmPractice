package day14

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/4 下午 10:36:01
 * @version 1.0.0
 * @description 三角形最小路径和
 * @filename TriangleMinimumPathSum.kt
 *
 */

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。*/

class Solution {


    fun minimumTotal(triangle: List<List<Int>>): Int {

        if (triangle.size == 1) {

            return triangle[0][0]

        }

        val dp = Array(triangle.size) {

            triangle[it].toIntArray()

        }

        for (x in dp.size - 2 downTo 0) {

            for (y in dp[x].indices) {

                dp[x][y] = minOf(dp[x + 1][y], dp[x + 1][y + 1]) + triangle[x][y]

            }

        }

        return dp[0][0]

    }


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/4 下午 11:07:55
     * @version 1.0.0
     * @description 此版本的空间复杂度仅为o(N)
     * @filename TriangleMinimumPathSum.kt
     *
     */
    fun minimumTotal_optimized(triangle: List<List<Int>>): Int {

        if (triangle.size == 1) {

            return triangle[0][0]

        }

        val dp = triangle[triangle.size - 1].toIntArray()

        for (x in triangle.size - 2 downTo 0) {

            for (y in triangle[x].indices) {

                dp[y] = minOf(dp[y], dp[y + 1]) + triangle[x][y]

            }

        }

        return dp[0]

    }


}