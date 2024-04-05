package day15

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/4/5 下午 10:51:40
 * @description 不同路径II
 * @filename DifferentPath2.kt
 */

/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。*/

class Solution {


    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

        if (obstacleGrid[0][0] == 1) {

            return 0

        }

        val dp = Array(obstacleGrid.size) {

            IntArray(obstacleGrid[it].size) { 0 }

        }

        dp[0][0] = 1

        for (x in 1..<obstacleGrid[0].size) {

            if (obstacleGrid[0][x] == 1) {

                break

            }

            dp[0][x] = dp[0][x - 1]

        }

        for (y in 1..<obstacleGrid.size) {

            if (obstacleGrid[y][0] == 1) {

                break

            }

            dp[y][0] = dp[y - 1][0]

        }

        for (y in 1..<obstacleGrid.size) {

            for (x in 1..<obstacleGrid[y].size) {

                if (obstacleGrid[y][x] == 0) {

                    dp[y][x] = (if (obstacleGrid[y][x - 1] == 0) dp[y][x - 1] else 0) +
                            (if (obstacleGrid[y - 1][x] == 0) dp[y - 1][x] else 0)

                }

            }

        }

        return dp[dp.size - 1][dp[0].size - 1]

    }


}
