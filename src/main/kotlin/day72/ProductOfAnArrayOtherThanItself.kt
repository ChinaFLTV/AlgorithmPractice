package day72

/**
 *
 * @author 啊啊啊/LiGuanda
 * @date 2024/6/5 17:25
 * @version 1.0.0
 * @description 除自身以外数组的乘积
 * @filename ProductOfAnArrayOtherThanItself.kt
 *
 */

/*给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。*/

class Solution {


    fun productExceptSelf(nums: IntArray): IntArray {

        val res = IntArray(nums.size)

        res[0] = 1

        for (i in 1..<nums.size) {

            res[i] = res[i - 1] * nums[i - 1]

        }

        var tempProduct = 1

        for (i in nums.size - 2 downTo 0) {

            tempProduct *= nums[i + 1]
            res[i] *= tempProduct

        }

        return res

    }


}