package day92

import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/26 PM 5:28:19
 * @version 1.0.0
 * @description 插入区间
 * @filename InsertInterval.kt
 *
 */

/*
给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。

在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。

返回插入之后的 intervals。

注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。*/

class Solution {


    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        if (intervals.isEmpty())
            return arrayOf(newInterval)

        val res = mutableListOf<IntArray>()

        var i = 0
        var isMerged = false

        if (newInterval[1] < intervals[0][0]) {

            res.add(newInterval)
            isMerged = true

        }

        while (i < intervals.size) {

            if (!isMerged && newInterval[0] <= intervals[i][1]) {

                val start = min(intervals[i][0], newInterval[0])
                var end = max(intervals[i][1], newInterval[1])

                while ((i + 1) < intervals.size && end >= intervals[i + 1][0]) {

                    end = max(intervals[++i][1], end)

                }

                res.add(intArrayOf(start, end))
                i++
                isMerged = true

            } else if ((i + 1) < intervals.size && !isMerged && intervals[i][1] < newInterval[0] && newInterval[1] < intervals[i + 1][0]) {

                res.add(intervals[i++])
                res.add(newInterval)
                isMerged = true

            } else {

                res.add(intervals[i++])

            }

        }

        if (!isMerged)
            res.add(newInterval)

        return res.toTypedArray()

    }


}