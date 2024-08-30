package day123

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/30 PM 7:16:13
 * @version 1.0.0
 * @description 和为 K 的子数组
 * @filename SubarraySumEqualsK.kt
 *
 */

/*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。



示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2


提示：

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107*/

class Solution {


    /*fun subarraySum(nums: IntArray, k: Int): Int {

        val dp = IntArray(nums.size) { 0 }

        for (i in 1..<nums.size) {

            var count = 0

            if (nums[i] == k)
                count++

            if (nums[i - 1] + nums[i] == k)
                count++

            dp[i] = dp[i - 1] + count

        }

        return dp.last()

    }*/


    /**
     *
     * @author <a href="https://leetcode.cn/u/liweiwei1419/">liweiwei1419</a>
     * @date 2024/8/30 PM 8:00:25
     * @version 1.0.0
     * @description <a href="暴力解法、前缀和、前缀和优化（Java）">暴力解法、前缀和、前缀和优化（Java）</a>
     * @filename SubarraySumEqualsK.kt
     *
     */
    fun subarraySum(nums: IntArray, k: Int): Int {

        val prefixSum = IntArray(nums.size + 1) { 0 }

        for (i in 1..nums.size) {

            prefixSum[i] = prefixSum[i - 1] + nums[i - 1]

        }

        var count = 0

        for (l in nums.indices) {

            for (r in l..<nums.size) {

                if (prefixSum[r + 1] - prefixSum[l] == k)
                    count++

            }

        }

        return count

    }


}