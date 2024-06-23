package day89

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/23 PM 6:24:26
 * @version 1.0.0
 * @description 最长连续序列
 * @filename LongestConsecutiveSequence.kt
 *
 */

/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。*/

class Solution {


    /*fun longestConsecutive(nums: IntArray): Int {

        val map = mutableMapOf<Int, Int>()
        var max = 0

        for (num in nums) {

            map[num] = 1

        }


        for (entry in map.entries) {

            if (map.containsKey(entry.key - 1)) {

                map[entry.key] = map[entry.key - 1]!! + 1
                max = max(max, map[entry.key]!!)

            }

        }

        return max

    }*/


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935">睡不醒的鲤鱼</a>
     * @date 2024/6/23 PM 7:12:24
     * @version 1.0.0
     * @description
     * @filename LongestConsecutiveSequence.kt
     *
     */
    fun longestConsecutive_answer_1(nums: IntArray): Int {

        val set = mutableSetOf<Int>()
        var max = 0

        for (num in nums)
            set.add(num)

        for (e in set) {

            if (!set.contains(e - 1)) {

                var count = 1
                var next = e + 1
                while (set.contains(next)) {

                    count++
                    next++

                }

                max = max(max, count)

            }

        }

        return max

    }


}

