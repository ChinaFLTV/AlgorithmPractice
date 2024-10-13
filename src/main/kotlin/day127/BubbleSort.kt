package day127

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/13 PM 3:57:14
 * @version 1.0.0
 * @description 冒泡排序算法
 * @filename BubbleSort.kt
 *
 */

fun bubbleSort2(nums: IntArray) {

    fun swap(nums: IntArray, idx1: Int, idx2: Int) {

        val tmp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = tmp

    }

    for (i in nums.size - 1 downTo 1) {

        for (j in 0..<i) {

            if (nums[j] > nums[j + 1])
                swap(nums, j, j + 1)

        }

    }

}