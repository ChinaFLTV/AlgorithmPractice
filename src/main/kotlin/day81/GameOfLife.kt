package day81

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/15 PM 7:12:25
 * @version 1.0.0
 * @description 生命游戏
 * @filename GameOfLife.kt
 *
 */

/*
根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。*/

class Solution {


    fun gameOfLife(board: Array<IntArray>) {

        val m = board.size
        val n = board[0].size

        val newBoard = Array(m) {

            IntArray(n)

        }
        var count = 0

        for (i in board.indices) {

            for (j in board[0].indices) {

                if (i - 1 >= 0 && j - 1 >= 0) {

                    count += board[i - 1][j - 1]

                }
                if (i - 1 >= 0) {

                    count += board[i - 1][j]

                }
                if (i - 1 >= 0 && j + 1 < n) {

                    count += board[i - 1][j + 1]

                }
                if (j - 1 >= 0) {

                    count += board[i][j - 1]

                }
                if (j + 1 < n) {

                    count += board[i][j + 1]

                }
                if (i + 1 < m && j - 1 >= 0) {

                    count += board[i + 1][j - 1]

                }
                if (i + 1 < m) {

                    count += board[i + 1][j]

                }
                if (i + 1 < m && j + 1 < n) {

                    count += board[i + 1][j + 1]

                }

                if (count < 2) {

                    newBoard[i][j] = 0

                } else if (count == 2) {

                    newBoard[i][j] = board[i][j]

                } else if (count == 3) {

                    newBoard[i][j] = 1

                } else {

                    newBoard[i][j] = 0

                }

                count = 0

            }

        }

        for (i in board.indices) {

            board[i] = newBoard[i]

        }

    }


    /**
     *
     * @author <a href="https://leetcode.cn/u/time-limit/">自在飞花</a>
     * @date 2024/6/15 PM 8:21:20
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/game-of-life/solutions/182495/c-wei-yun-suan-yuan-di-cao-zuo-ji-bai-shuang-bai-b/?envType=study-plan-v2&envId=top-interview-150">题解</a>
     * @filename GameOfLife.kt
     *
     */
    fun gameOfLife_answer_1(board: Array<IntArray>) {

        val m = board.size
        val n = board[0].size
        val dx = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
        val dy = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)

        for (i in board.indices) {

            for (j in board[0].indices) {

                var aliveCount = 0
                for (k in 0..7) {

                    val nx = j + dx[k]
                    val ny = i + dy[k]

                    if (nx in 0..<n && ny in 0..<m) {

                        aliveCount += board[ny][nx] and 255

                    }

                }

                if (aliveCount == 2) {

                    board[i][j] = board[i][j] or (board[i][j] shl 8)

                } else if (aliveCount == 3) {

                    board[i][j] = board[i][j] or (1 shl 8)

                }

            }

        }

        for (i in board.indices) {

            for (j in board[0].indices) {

                board[i][j] = board[i][j] shr 8

            }

        }

    }


}


fun main() {

    val board = Array(4) {

        when (it) {

            0 -> intArrayOf(0, 1, 0)
            1 -> intArrayOf(0, 0, 1)
            2 -> intArrayOf(1, 1, 1)
            3 -> intArrayOf(0, 0, 0)
            else -> intArrayOf()

        }

    }

    Solution().gameOfLife(board)

}