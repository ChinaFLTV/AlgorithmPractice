package day109

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/30 PM 5:30:38
 * @version 1.0.0
 * @description 岛屿的最大面积
 * @filename MaxAreaOfIsland.kt
 *
 */

/*
给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。*/

class Solution2 {


    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        val m = grid.size
        val n = grid[0].size

        var maxArea = 0

        for (i in 0..<m) {

            for (j in 0..<n) {

                maxArea = maxOf(maxArea, probe(grid, i, j))

            }

        }

        return maxArea

    }


    private fun probe(grid: Array<IntArray>, i: Int, j: Int): Int {

        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0)
            return 0

        grid[i][j] = 0

        var tempArea = 1

        tempArea += probe(grid, i, j + 1)
        tempArea += probe(grid, i + 1, j)
        tempArea += probe(grid, i, j - 1)
        tempArea += probe(grid, i - 1, j)

        return tempArea

    }


}