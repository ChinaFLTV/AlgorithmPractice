package day80

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/14 PM 4:44:57
 * @version 1.0.0
 * @description 矩阵置零
 * @filename SetMatrixZeroes.kt
 *
 */

/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。*/

class Solution {


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/6/14 PM 6:11:59
     * @version 1.0.0
     * @description
     * @filename SetMatrixZeroes.kt
     *
     */
    fun setZeroes_answer_1(matrix: Array<IntArray>) {

        val m = matrix.size
        val n = matrix[0].size
        var rowZero = false
        var colZero = false

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0
                    matrix[0][j] = 0

                    if (i == 0)
                        rowZero = true

                    if (j == 0)
                        colZero = true

                }

            }

        }

        for (i in 1..<m) {

            for (j in 1..<n) {

                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0

            }

        }

        if (rowZero)
            for (j in matrix[0].indices)
                matrix[0][j] = 0

        if (colZero)
            for (i in matrix.indices)
                matrix[i][0] = 0

    }


}