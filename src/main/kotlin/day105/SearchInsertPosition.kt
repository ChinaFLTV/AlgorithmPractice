package day105

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/12 14:45
 * @version 1.0.0
 * @description 搜索插入位置
 * @filename SearchInsertPosition.kt
 *
 */

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。*/

class Solution3 {


    fun searchInsert(nums: IntArray, target: Int): Int {

        var left = 0
        var right = nums.size - 1

        var res = -1

        while (left <= right) {

            val pivot = (left + right) / 2

            if (nums[pivot] < target) {

                left = pivot + 1

            } else if (nums[pivot] == target) {

                res = pivot
                break

            } else {

                right = pivot - 1

            }

        }

        return if (res == -1) left else res

    }


}