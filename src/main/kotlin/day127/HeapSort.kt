package day127

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/13 PM 4:51:49
 * @version 1.0.0
 * @description 堆排序算法
 * @filename HeapSort.kt
 *
 */

fun shiftDown(nums: IntArray, len: Int, posIdx: Int) {

    val leftChildIdx = 2 * posIdx + 1
    val rightChildIdx = 2 * posIdx + 2

    var needChangeIdx = posIdx

    if (leftChildIdx < len && nums[leftChildIdx] > nums[needChangeIdx])
        needChangeIdx = leftChildIdx

    if (rightChildIdx < len && nums[rightChildIdx] > nums[needChangeIdx])
        needChangeIdx = rightChildIdx

    if (needChangeIdx != posIdx) {

        swap(nums, posIdx, needChangeIdx)
        shiftDown(nums, len, needChangeIdx)

    }

}


fun heapify(nums: IntArray, len: Int) {

    for (i in len / 2 - 1 downTo 0) {

        shiftDown(nums, len, i)

    }

}


fun heapSort(nums: IntArray) {

    for (i in nums.size - 1 downTo 0) {

        heapify(nums, i + 1)
        swap(nums, 0, i)

    }

}