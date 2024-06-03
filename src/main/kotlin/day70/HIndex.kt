package day70

import kotlin.math.max
import kotlin.math.min

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/3 PM 6:48:00
 * @version 1.0.0
 * @description H 指数
 * @filename HIndex.kt
 *
 */

/*
给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。

根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。*/

class Solution {


    fun hIndex(citations: IntArray): Int {

        var maxH = 0

        citations.sort()

        for (i in citations.indices) {

            maxH = max(maxH, min(citations[i], citations.size - i))

        }

        return maxH

    }


}