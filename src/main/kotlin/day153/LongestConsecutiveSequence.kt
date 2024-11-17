package day153

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/17 PM 2:51:42
 * @version 1.0.0
 * @description 128. 最长连续序列
 * @filename LongestConsecutiveSequence.kt
 *
 */

/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109*/

class Solution {


    fun longestConsecutive(nums: IntArray): Int {

        val set = mutableSetOf(*nums.toTypedArray())

        if (set.size <= 1)
            return set.size

        var maxLen = 1

        for (e in set) {

            if (!set.contains(e - 1)) {

                var tempLen = 1
                var delta = 1

                while (true) {

                    if (set.contains(e + delta)) {

                        tempLen++
                        delta++

                    } else {

                        break

                    }

                }

                maxLen = max(maxLen, tempLen)

            }

        }

        return maxLen

    }


}


fun main() {

    Solution().longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))

}