package day10

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/31 下午 9:57:52
 * @version 1.0.0
 * @description 打家劫舍
 * @filename Loot.kt
 *
 */

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。*/

class Solution1 {


    fun rob(nums: IntArray): Int {

        if (nums.size == 1) {

            return nums[0]

        }

        val dp = Array(nums.size) { 0 }

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for (i in 2..<nums.size) {

            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])

        }

        return dp[nums.size - 1]

    }


}