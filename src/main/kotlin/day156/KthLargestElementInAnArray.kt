package day156

import java.util.*

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/21 PM 6:40:42
 * @version 1.0.0
 * @description 215. 数组中的第K个最大元素
 * @filename KthLargestElementInAnArray.kt
 *
 */

/*
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。



示例 1:

输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4


提示：

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/liweiwei1419/">liweiwei1419</a>
     * @date 2024/11/21 PM 7:21:33
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/">通过 partition 减治 + 优先队列（Java）</a>
     * @filename KthLargestElementInAnArray.kt
     *
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val minHeap = PriorityQueue<Int> { a, b -> a.compareTo(b) }
        for (i in 0..<k) {

            minHeap.offer(nums[i])

        }

        for (i in k..<nums.size) {

            val curMinNum = minHeap.peek()
            if (curMinNum < nums[i]) {

                minHeap.poll()
                minHeap.offer(nums[i])

            }

        }

        return minHeap.peek()

    }


}