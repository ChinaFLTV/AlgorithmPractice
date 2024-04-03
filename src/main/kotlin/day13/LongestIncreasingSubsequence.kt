package day13

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/3 下午 10:45:45
 * @version 1.0.0
 * @description 最长递增子序列
 * @filename LongestIncreasingSubsequence.kt
 *
 */

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
子序列。*/

class Solution {


    fun lengthOfLIS(nums: IntArray): Int {

        val dp = Array(nums.size) { 1 }

        for (i in 1..<nums.size) {

            for (j in i - 1 downTo 0) {

                if (nums[j] < nums[i]) {

                    dp[i] = maxOf(dp[i], dp[j] + 1)

                }

            }

        }

        return dp.max()

    }


}