package day119

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/20 PM 4:56:51
 * @version 1.0.0
 * @description 接雨水
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

class Solution2 {


    /**
     *
     * @author <a href="https://leetcode.cn/u/i3lissful-maxvvellnic/">I3lissful MaxvvellNIC</a>
     * @date 2024/8/20 PM 5:29:33
     * @version 1.0.0
     * @description 双指针的个人理解，Java，时间O(n)，空间O(1)(https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/comments/2204905)
     * @filename TrappingRainWater.kt
     *
     */
    fun trap(height: IntArray): Int {

        if (height.size <= 2)
            return 0

        var left = 0
        var right = height.size - 1

        var leftMax = height[left]
        var rightMax = height[right]

        left++
        right--

        var res = 0

        while (left <= right) {

            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])

            res += if (leftMax < rightMax)
                leftMax - height[left++]
            else
                rightMax - height[right--]

        }

        return res

    }


}