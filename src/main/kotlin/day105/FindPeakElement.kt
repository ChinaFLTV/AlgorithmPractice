package day105

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/7/12 16:36
 * @version 1.0.0
 * @description 寻找峰值
 * @filename FindPeakElement.kt
 *
 */

/*
峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。*/

class Solution5 {


    fun findPeakElement(nums: IntArray): Int {

        var left = 0
        var right = nums.size - 1

        while (left < right) {

            val pivot = (left + right) / 2

            if (nums[pivot] < nums[pivot + 1])
                left = pivot + 1
            else
                right = pivot

        }

        return left

    }


}