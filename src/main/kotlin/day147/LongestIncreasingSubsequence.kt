package day147

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/10 PM 1:32:54
 * @version 1.0.0
 * @description 300. 最长递增子序列
 * @filename LongestIncreasingSubsequence.kt
 *
 */

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
子序列
。


示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1


提示：

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


进阶：

你能将算法的时间复杂度降低到 O(n log(n)) 吗?*/

class Solution {


    fun lengthOfLIS(nums: IntArray): Int {

        if (nums.size <= 1)
            return nums.size

        val dp = Array(nums.size) { 1 }

        for (i in 1..<nums.size) {

            for (j in i - 1 downTo 0) {

                if (nums[j] < nums[i]) {

                    dp[i] = max(dp[i], dp[j] + 1)

                }

            }

        }

        return dp.max()

    }


}