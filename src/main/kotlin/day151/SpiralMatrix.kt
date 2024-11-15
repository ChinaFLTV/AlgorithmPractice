package day151

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/15 PM 2:31:10
 * @version 1.0.0
 * @description 54. 螺旋矩阵
 * @filename SpiralMatrix.kt
 *
 */

/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：


输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100*/

class Solution {


    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        if (matrix.isEmpty())
            return listOf()

        val width = matrix[0].size
        val height = matrix.size

        var left = 0
        var right = width - 1
        var top = 0
        var bottom = height - 1

        val res = mutableListOf<Int>()

        while (true) {

            for (i in left..right)
                res.add(matrix[top][i])

            if (++top > bottom)
                break

            for (i in top..bottom)
                res.add(matrix[i][right])

            if (--right < left)
                break

            for (i in right downTo left)
                res.add(matrix[bottom][i])

            if (--bottom < top)
                break

            for (i in bottom downTo top)
                res.add(matrix[i][left])

            if (++left > right)
                break

        }

        return res

    }


}