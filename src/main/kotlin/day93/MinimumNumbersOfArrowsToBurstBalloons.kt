package day93

import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/27 PM 5:43:26
 * @version 1.0.0
 * @description 用最少数量的箭引爆气球
 * @filename MinimumNumbersOfArrowsToBurstBalloons.kt
 *
 */

/*
有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。

一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。

给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。*/

class Solution {


    /**
     *
     * @author <a href="https://space.bilibili.com/525438321?spm_id_from=333.337.search-card.all.click">代码随想录</a>
     * @date 2024/6/27 PM 6:46:28
     * @version 1.0.0
     * @description 贪心算法
     * @filename MinimumNumbersOfArrowsToBurstBalloons.kt
     *
     */
    fun findMinArrowShots_answer_1(points: Array<IntArray>): Int {

        points.sortWith(compareBy({ it[0] }, { it[1] }))

        var count = 0
        var i = 0

        while (i < points.size) {

            var end = points[i][1]

            while ((i + 1) < points.size && end >= points[i + 1][0]) {

                end = min(end, points[++i][1])

            }

            count++
            i++

        }

        return count

    }


}