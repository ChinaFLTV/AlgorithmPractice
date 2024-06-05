package day69

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/2 PM 7:37:17
 * @version 1.0.0
 * @description 跳跃游戏II
 * @filename HipAndHopGame2.kt
 *
 */

/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。*/

class Solution {


    fun jump(nums: IntArray): Int {

        if (nums.size == 1) return 0

        var steps = 0
        var cover = 0
        var nextCover = -1

        for (i in 0..nums.size - 2) {

            if (i + nums[i] >= nums.size - 1)
                return steps + 1
            else {

                nextCover = max(nextCover, i + nums[i])
                if (i == cover) {

                    steps++
                    cover = nextCover

                }

            }

        }

        return steps

    }


}