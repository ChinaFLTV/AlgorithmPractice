package day157

import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/22 PM 2:39:23
 * @version 1.0.0
 * @description 42. 接雨水
 * @filename TrappingRainWater.kt
 *
 */

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/windliang/">windliang</a>
     * @date 2024/11/22 PM 3:39:22
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/">详细通俗的思路分析，多解法</a>
     * @filename TrappingRainWater.kt
     *
     */
    fun trap(height: IntArray): Int {

        val leftMax = Array(height.size) { height[it] }
        val rightMax = Array(height.size) { height[it] }

        var sum = 0

        for (i in 1..height.size - 2) {

            leftMax[i] = max(leftMax[i - 1], height[i - 1])

        }

        for (i in height.size - 2 downTo 1) {

            rightMax[i] = max(rightMax[i + 1], height[i + 1])

        }

        for (i in 1..height.size - 2) {

            val tempMin = min(leftMax[i], rightMax[i])

            if (tempMin > height[i]) {

                sum += (tempMin - height[i])

            }

        }

        return sum

    }


}