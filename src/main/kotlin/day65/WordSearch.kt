package day65

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/29 PM 6:58:59
 * @version 1.0.0
 * @description 单词搜素
 * @filename WordSearch.kt
 *
 */

/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。*/

class Solution {


    fun exist(board: Array<CharArray>, word: String): Boolean {

        for (i in board.indices) {

            for (j in board[0].indices) {

                if (dfs(board, word, 0, j, i)) return true

            }

        }

        return false

    }


    private fun dfs(board: Array<CharArray>, word: String, idx: Int, bx: Int, by: Int): Boolean {

        if (idx >= word.length || bx < 0 || bx >= board[0].size || by < 0 || by >= board.size) return false

        if (word[idx] != board[by][bx]) return false

        if (idx == word.length - 1) return true

        val temp = board[by][bx]
        board[by][bx] = '*'

        val isFound = dfs(board, word, idx + 1, bx, by - 1)
                || dfs(board, word, idx + 1, bx + 1, by)
                || dfs(board, word, idx + 1, bx, by + 1)
                || dfs(board, word, idx + 1, bx - 1, by)

        board[by][bx] = temp

        return isFound

    }


}