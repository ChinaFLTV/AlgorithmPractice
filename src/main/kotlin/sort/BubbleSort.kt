package sort

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/28 PM 4:15:48
 * @version 1.0.0
 * @description 冒泡排序
 * @filename BubbleSort.kt
 *
 */


fun bubbleSort(nums: IntArray) {

    fun swap(nums: IntArray, idx1: Int, idx2: Int) {

        val temp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = temp

    }

    for (i in nums.size - 1 downTo 1) {

        for (j in 0..<i) {

            if (nums[j] > nums[j + 1])
                swap(nums, j, j + 1)

        }

    }

}


fun main() {

    val nums = intArrayOf(6, 4, 2, 7, 9, 1, 3, 5, 0, 8)
    bubbleSort(nums)
    println(nums.contentToString())

}