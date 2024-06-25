package day91

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/25 PM 5:44:27
 * @version 1.0.0
 * @description 合并区间
 * @filename MergeIntervals.kt
 *
 */

/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start i, end i] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。*/

class Solution {


    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        val res = arrayListOf<IntArray>()

        intervals.sortWith(compareBy({ it[0] }, { it[1] }))

        var i = 0

        while (i < intervals.size) {

            val start = intervals[i][0]
            var end = intervals[i][1]

            while ((i + 1) < intervals.size && end >= intervals[i + 1][0]) {

                end = max(end, intervals[++i][1])

            }

            res.add(intArrayOf(start, end))
            i++

        }

        return res.toArray(Array(0) { intArrayOf() })

    }


}


fun main() {

    val arr = Array(5) { intArrayOf() }

    arr[0] = intArrayOf(2, 3)
    arr[1] = intArrayOf(4, 5)
    arr[2] = intArrayOf(6, 7)
    arr[3] = intArrayOf(8, 9)
    arr[4] = intArrayOf(1, 10)

    Solution().merge(arr)

}