package day2

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/3/22 下午 3:29:22
 * @version 1.0.0
 * @description 多数元素(众数)
 * @filename Mode.kt
 *
 */

/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/


class Solution3 {


    fun majorityElement(nums: IntArray): Int {

        val map: HashMap<Int, Int> = hashMapOf()

        nums.forEach {

            map[it] = map.getOrDefault(it, 0) + 1

        }

        return map.maxByOrNull { it.value }!!.key


    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/22 下午 4:10:55
     * @version 1.0.0
     * @description 分治
     * @filename Mode.kt
     *
     */
    fun majorityElement_answer_1(nums: IntArray): Int {


        fun countMode(nums: IntArray, target: Int, left: Int, right: Int): Int {

            var count = 0

            for (i in left..right) {

                if (nums[i] == target) count++

            }

            return count

        }


        fun majorityElementRec(nums: IntArray, left: Int, right: Int): Int {

            if (left == right) {

                return nums[left]

            }

            val mid: Int = (left + right) / 2

            val leftMode = majorityElementRec(nums, left, mid)
            val rightMode = majorityElementRec(nums, mid + 1, right)


            if (leftMode == rightMode) {

                return leftMode

            }

            val leftMode2 = countMode(nums, leftMode, left, right)
            val rightMode2 = countMode(nums, rightMode, left, right)

            return max(leftMode2, rightMode2)


        }

        return majorityElementRec(nums, 0, nums.size - 1)

    }


    /**
     *
     * @author 力扣官方
     * @date 2024/3/22 下午 4:38:05
     * @version 1.0.0
     * @description Boyer-Moore算法
     * @filename Mode.kt
     *
     */
    fun majorityElement_answer_2(nums: IntArray): Int? {

        var candidate: Int? = null
        var count = 0

        nums.forEach {

            if (count == 0) candidate = it

            if (candidate == it) {

                count++

            } else {

                count--

            }

        }

        return candidate

    }


}