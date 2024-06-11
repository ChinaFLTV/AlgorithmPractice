package day77

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/11 PM 6:14:33
 * @version 1.0.0
 * @description 有效的数独
 * @filename ValidSudoku.kt
 *
 */

/*
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）


注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/liujin-4/">liujin</a>
     * @date 2024/6/11 PM 7:26:06
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/valid-sudoku/solutions/58669/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/?envType=study-plan-v2&envId=top-interview-150">原题解</a>
     * @filename ValidSudoku.kt
     *
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rowHash = Array(9) {

            IntArray(10) { 0 }

        }
        val colHash = Array(9) {

            IntArray(10) { 0 }

        }
        val boxHash = Array(9) {

            IntArray(10) { 0 }

        }

        for (i in 0..8) {

            for (j in 0..8) {

                if (board[i][j] == '.')
                    continue
                else {

                    val num = board[i][j] - '0'
                    if (rowHash[i][num] == 1)
                        return false
                    if (colHash[j][num] == 1)
                        return false
                    if (boxHash[3 * (i / 3) + j / 3][num] == 1)
                        return false

                    rowHash[i][num] = 1
                    colHash[j][num] = 1
                    boxHash[3 * (i / 3) + j / 3][num] = 1

                }

            }

        }

        return true

    }


}