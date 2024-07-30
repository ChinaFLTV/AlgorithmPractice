package day109

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/30 PM 4:17:53
 * @version 1.0.0
 * @description 岛屿数量
 * @filename NumberOfIslands.kt
 *
 */

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。*/

class Solution {


    fun numIslands(grid: Array<CharArray>): Int {

        val m = grid.size
        val n = grid[0].size

        var count = 0

        for (i in 0..<m) {

            for (j in 0..<n) {

                if (grid[i][j] == '1') {

                    count++
                    probe(grid, i, j)

                }

            }

        }

        return count

    }


    private fun probe(grid: Array<CharArray>, i: Int, j: Int) {

        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size)
            return

        if (grid[i][j] == '1') {

            grid[i][j] = '0'

            probe(grid, i, j + 1)
            probe(grid, i + 1, j)
            probe(grid, i, j - 1)
            probe(grid, i - 1, j)

        }

    }


}