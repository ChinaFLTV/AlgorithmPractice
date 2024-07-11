package day104

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/11 AM 11:36:43
 * @version 1.0.0
 * @description 只出现一次的数字 II
 * @filename SingleNumber2.kt
 *
 */

/*
给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/giuliano/">GluLiano</a>
     * @date 2024/7/11 AM 11:54:22
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/single-number-ii/description/comments/2149696">根据32位int，把每个数位相加再对3取的余数即可</a>
     * @filename SingleNumber2.kt
     *
     */
    fun singleNumber_answer_1(nums: IntArray): Int {

        val bits = IntArray(32)

        for (i in nums.indices) {

            for (j in 31 downTo 0) {

                bits[j] += (nums[i] and 1)
                nums[i] = nums[i] shr 1

            }

        }

        var res = 0

        for (i in bits.indices) {

            // res += ((bits[i] % 3) shl (31 - i))
            res = res or ((bits[i] % 3) shl (31 - i))

        }

        return res

    }


}