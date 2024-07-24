package sort

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/14 20:09
 * @version 1.0.0
 * @description 快速排序
 * @filename QuickSort.kt
 *
 */

fun swap(nums: IntArray, left: Int, right: Int) {

    val temp = nums[left]
    nums[left] = nums[right]
    nums[right] = temp

}


fun partition(nums: IntArray, left: Int, right: Int): Int {

    var i = left
    var j = right

    while (i < j) {

        while (i < j && nums[j] >= nums[left])
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


fun main() {

    val nums = intArrayOf(6, 4, 2, 7, 9, 1, 3, 5, 0, 8)
    quickSort(nums, 0, nums.size - 1)
    println(nums.contentToString())

}