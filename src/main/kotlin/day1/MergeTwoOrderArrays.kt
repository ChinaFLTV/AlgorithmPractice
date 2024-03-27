package day1

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/21 下午 6:17:49
 * @version 1.0.0
 * @description 88.合并两个有序数组
 * @filename MergeTwoOrderArrays.kt
 *
 */

/*
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。*/

class Solution1 {


    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        var pointer1: Int = m - 1// num1有效子数组的指针
        var pointer2: Int = n - 1// num2数组的指针
        var pointer3: Int = m + n - 1// num1全数组的指针

        // 逆序比较
        while (pointer3 >= 0) {

            // 两数组其中已经有一个或两个全部参与了最终排序
            if (pointer1 == -1 || pointer2 == -1) {

                break

            }

            if (nums1[pointer1] > nums2[pointer2]) {

                nums1[pointer3--] = nums1[pointer1--]

            } else {

                nums1[pointer3--] = nums2[pointer2--]

            }

        }

        // 不需要再将nums1的元素加入最终数组，因为nums1的元素本来就在最终数组中，且已经被事先排好序了
        // 如果nums1还有盈余，则倒序顺次加入最终数组
        /*while (pointer1 >= 0) {

            nums1[pointer3--] = nums1[pointer1--]

        }*/

        // nums2有盈余
        while (pointer2 >= 0) {

            nums1[pointer3--] = nums2[pointer2--]

        }


    }


}


fun main() {

    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)
    Solution1().merge(nums1, 3, nums2, 3)
    println(nums1.contentToString())

}

