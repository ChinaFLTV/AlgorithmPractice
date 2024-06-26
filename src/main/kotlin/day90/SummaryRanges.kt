package day90

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/24 PM 8:26:42
 * @version 1.0.0
 * @description 汇总区间
 * @filename SummaryRanges.kt
 *
 */

/*
给定一个  无重复元素 的 有序 整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b*/

class Solution {


    fun summaryRanges(nums: IntArray): List<String> {

        if (nums.isEmpty())
            return emptyList()

        val res = mutableListOf<String>()

        var i = 0

        while (i < nums.size) {

            val start = nums[i]
            var end = nums[i]

            while ((i + 1) < nums.size && nums[i] + 1 == nums[i + 1]) {

                end = nums[++i]

            }

            if (start == end) {

                res.add(start.toString())

            } else {

                res.add("$start->$end")

            }

            i++

        }

        return res

    }


}