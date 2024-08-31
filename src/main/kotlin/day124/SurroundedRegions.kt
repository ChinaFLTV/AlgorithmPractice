package day124

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/31 PM 3:58:01
 * @version 1.0.0
 * @description 被围绕的区域
 * @filename SurroundedRegions.kt
 *
 */

/*
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：

连接：一个单元格与水平或垂直方向上相邻的单元格连接。
区域：连接所有 'O' 的单元格来形成一个区域。
围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。



示例 1：

输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

解释：


在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。

示例 2：

输入：board = [["X"]]

输出：[["X"]]



提示：

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] 为 'X' 或 'O'*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/ac_pipe/">Xdims</a>
     * @date 2024/8/31 PM 4:17:17
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/surrounded-regions/solutions/6067/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/?envType=study-plan-v2&envId=top-interview-150">bfs+递归 dfs+非递归 dfs+并查集</a>
     * @filename SurroundedRegions.kt
     *
     */
    fun solve(board: Array<CharArray>) {

        if (board.isEmpty())
            return

        val m = board.size
        val n = board[0].size

        for (i in 0..<m) {

            for (j in 0..<n) {

                val isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1
                if (isEdge && board[i][j] == 'O') {

                    dfs(board, i, j)

                }

            }

        }


        for (i in 0..<m) {

            for (j in 0..<n) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X'

                if (board[i][j] == '#')
                    board[i][j] = 'O'

            }

        }

    }


    private fun dfs(board: Array<CharArray>, i: Int, j: Int) {

        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || board[i][j] == 'X' || board[i][j] == '#')
            return

        board[i][j] = '#'

        dfs(board, i - 1, j)
        dfs(board, i, j + 1)
        dfs(board, i + 1, j)
        dfs(board, i, j - 1)

    }


}