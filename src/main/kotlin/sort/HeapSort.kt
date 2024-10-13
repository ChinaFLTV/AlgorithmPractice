package sort

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/24 12:32
 * @version 1.0.0
 * @description 堆排序
 * @filename HeapSort.kt
 *
 */

fun shiftDown(nums: IntArray, len: Int, posIndex: Int) {

    val leftChildIndex = 2 * posIndex + 1
    val rightChildIndex = 2 * posIndex + 2

    var needChangeIndex = posIndex
    if (leftChildIndex < len && nums[leftChildIndex] > nums[needChangeIndex]) needChangeIndex = leftChildIndex

    if (rightChildIndex < len && nums[rightChildIndex] > nums[needChangeIndex]) needChangeIndex = rightChildIndex

    if (needChangeIndex == posIndex) return

    swap(nums, posIndex, needChangeIndex)

    shiftDown(nums, len, needChangeIndex)

}


fun heapify(nums: IntArray, len: Int) {

    for (i in (len / 2 - 1) downTo 0) {

        shiftDown(nums, len, i)

    }

}


fun heapSort(nums: IntArray) {

    heapify(nums, nums.size)

    for (i in nums.size - 1 downTo 1) {

        swap(nums, 0, i)
        heapify(nums, i)

    }

}


fun main() {

    val nums = intArrayOf(2, 5, 3, 9, 6, 4, 1, 7)

    heapSort(nums)

    println(nums.contentToString())

}