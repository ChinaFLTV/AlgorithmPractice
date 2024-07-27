package day105

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/12 15:53
 * @version 1.0.0
 * @description 搜索二维矩阵
 * @filename SearchA2DMatrix.kt
 *
 */

/*
给你一个满足下述两条属性的 m x n 整数矩阵：

每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。*/

class Solution4 {


    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        for (nums in matrix) {

            if (target >= nums[0] && target <= nums[nums.size - 1]) {

                var left = 0
                var right = nums.size - 1
                while (left <= right) {

                    val pivot = (left + right) / 2

                    if (nums[pivot] < target) {

                        left = pivot + 1

                    } else if (nums[pivot] == target) {

                        return true

                    } else {

                        right = pivot - 1

                    }

                }

                break

            }

        }

        return false

    }


    fun searchMatrix_answer_1(matrix: Array<IntArray>, target: Int): Boolean {

        val m = matrix.size
        val n = matrix[0].size

        var left = 0
        var right = m * n - 1

        while (left <= right) {

            val pivot = (left + right) / 2
            val temp = matrix[pivot / n][pivot % n]

            if (temp < target) {

                left = pivot + 1

            } else if (temp == target) {

                return true

            } else {

                right = pivot - 1

            }

        }

        return false

    }


}