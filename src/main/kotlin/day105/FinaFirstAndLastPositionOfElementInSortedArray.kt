package day105

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/12 20:03
 * @version 1.0.0
 * @description 在排序数组中查找元素的第一个和最后一个位置
 * @filename FinaFirstAndLastPositionOfElementInSortedArray.kt
 *
 */

/*
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。*/

class Solution7 {


    fun searchRange(nums: IntArray, target: Int): IntArray {

        var first = -1
        var last = -1


        var left = 0
        var right = nums.size - 1

        while (left <= right) {

            val pivot = (left + right) / 2

            if (nums[pivot] < target) {

                left = pivot + 1

            } else if (nums[pivot] == target) {

                first = pivot
                right = pivot - 1

            } else {

                right = pivot - 1

            }

        }


        left = 0
        right = nums.size - 1

        while (left <= right) {

            val pivot = (left + right) / 2

            if (nums[pivot] < target) {

                left = pivot + 1

            } else if (nums[pivot] == target) {

                last = pivot
                left = pivot + 1

            } else {

                right = pivot - 1

            }

        }

        return intArrayOf(first, last)

    }


}