package day79

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/13 PM 5:44:16
 * @version 1.0.0
 * @description 旋转图像
 * @filename RotateImage.kt
 *
 */

/*
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。*/

class Solution {


    fun rotate(matrix: Array<IntArray>) {

        for (i in matrix.indices) {

            for (j in 0..<i) {

                swap(matrix, i, j, j, i)

            }

        }

        for (i in matrix.indices) {

            for (j in 0..<matrix.size / 2) {

                swap(matrix, i, j, i, matrix.size - 1 - j)

            }

        }

    }


    private fun swap(matrix: Array<IntArray>, ay: Int, ax: Int, by: Int, bx: Int) {

        val temp = matrix[ay][ax]

        matrix[ay][ax] = matrix[by][bx]
        matrix[by][bx] = temp

    }


}