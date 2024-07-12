package day105

import kotlin.random.Random

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/12 13:19
 * @version 1.0.0
 * @description 数组中的第K个最大元素
 * @filename KthLargestElementInAnArray.kt
 *
 */

/*
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。*/

class Solution2 {


    private val random = Random(666)


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/7/12 14:04
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/?envType=study-plan-v2&envId=top-interview-150">数组中的第 K 个最大元素（分治，清晰图解）</a>
     * @filename KthLargestElementInAnArray.kt
     *
     */
    fun findKthLargest_answer_1(nums: IntArray, k: Int): Int {

        return quickSearch(nums, k)

    }


    private fun quickSearch(nums: IntArray, k: Int): Int {

        val pivot: Int = nums[random.nextInt(999) % nums.size]

        val small = mutableListOf<Int>()
        val equal = mutableListOf<Int>()
        val big = mutableListOf<Int>()

        for (num in nums) {

            if (num > pivot) {

                big.add(num)

            } else if (num == pivot) {

                equal.add(num)

            } else {

                small.add(num)

            }

        }

        if (k <= big.size)
            return quickSearch(big.toIntArray(), k)

        if (k > (big.size + equal.size))
            return quickSearch(small.toIntArray(), k - big.size - equal.size)

        return pivot

    }


}