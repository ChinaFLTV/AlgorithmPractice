package day61

import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/25 PM 11:23:20
 * @version 1.0.0
 * @description 长度最小的子数组
 * @filename TheSmallestLengthSubarray.kt
 *
 */

/*给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 连续
子数组
[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。*/

class Solution {


    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        var left = 0
        var sum = 0
        var minLen = Int.MAX_VALUE
        var curLen = 0


        for (right in nums.indices) {

            sum += nums[right]
            curLen++

            while (sum >= target && left <= right) {

                minLen = min(minLen, curLen)
                sum -= nums[left++]
                curLen--

            }

        }

        return if (minLen == Int.MAX_VALUE) 0 else minLen

    }


}