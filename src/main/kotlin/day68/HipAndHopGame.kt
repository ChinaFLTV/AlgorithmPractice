package day68

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/1 PM 7:28:25
 * @version 1.0.0
 * @description 跳跃游戏
 * @filename HipAndHopGame.kt
 *
 */

/*
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。*/

class Solution {


    /*fun canJump(nums: IntArray): Boolean {

        var pos = 0

        while (pos < nums.size) {

            if (pos == nums.size - 1) return true
            if (nums[pos] == 0) return false

            pos += nums[pos]

        }

        return true

    }*/


    fun canJump(nums: IntArray): Boolean {

        val nums2 = IntArray(nums.size) { 0 }
        for (i in 0..nums.size - 2) {

            for (j in 1..nums[i]) {

                if (i + j < nums2.size) nums2[i + j]++

            }

        }

        for (i in 1..<nums2.size) {

            if (nums2[i] == 0) return false

        }

        return true

    }


    /**
     *
     * @author <a href="https://space.bilibili.com/525438321?spm_id_from=333.337.search-card.all.click">代码随想录</a>
     * @date 2024/6/1 PM 8:12:19
     * @version 1.0.0
     * @description 贪心算法
     * @filename HipAndHopGame.kt
     *
     */
    fun canJump_answer_1(nums: IntArray): Boolean {

        if (nums.size == 1) return true

        var cover = nums[0]
        var i = 1
        while (i <= cover) {

            cover = max(cover, i + nums[i++])
            if (cover >= nums.size - 1) return true

        }

        return false

    }


}


fun main() {

    val b = Solution().canJump_answer_1(intArrayOf(1, 1, 1, 0))
    println(b)

}