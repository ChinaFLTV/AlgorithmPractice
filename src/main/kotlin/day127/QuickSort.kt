package day127

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/13 PM 4:14:08
 * @version 1.0.0
 * @description 快速排序算法
 * @filename QuickSort.kt
 *
 */

fun swap(nums: IntArray, idx1: Int, idx2: Int) {

    val tmp = nums[idx1]
    nums[idx1] = nums[idx2]
    nums[idx2] = tmp

}


fun partition(nums: IntArray, left: Int, right: Int): Int {

    var i = left
    var j = right

    while (i < j) {

        while (i < j && nums[left] <= nums[j])
            j--

        while (i < j && nums[i] <= nums[left])
            i++

        swap(nums, i, j)

    }

    swap(nums, left, i)

    return i

}


fun quickSort(nums: IntArray, left: Int, right: Int) {

    if (left >= right)
        return

    val pivot = partition(nums, left, right)
    quickSort(nums, left, pivot - 1)
    quickSort(nums, pivot + 1, right)

}