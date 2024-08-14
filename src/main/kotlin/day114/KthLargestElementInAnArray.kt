package day114

import java.util.*
import kotlin.random.Random

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/14 PM 1:39:46
 * @version 1.0.0
 * @description 数组中的第K个最大元素
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
     * @author <a href="https://leetcode.cn/u/w41rdo/">🎯w4irdo</a>
     * @date 2024/8/14 PM 2:04:36
     * @version 1.0.0
     * @description 优先队列可以用一个 for 循环解决哈。就是在 for 循环里面判断小顶堆里面的 size() 是否大于 k 个数，是的话就 poll() 出去；整个 for 循环结束之后剩下来的就是 k 个数的小顶堆。堆顶即第 k 大的数。(https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/comments/453363)
     * @filename KthLargestElementInAnArray.kt
     *
     */
    fun findKthLargest_1(nums: IntArray, k: Int): Int {

        val priorityQueue = PriorityQueue<Int>()

        for (num in nums) {

            priorityQueue.add(num)

            if (priorityQueue.size > k)
                priorityQueue.poll()

        }

        return priorityQueue.peek()

    }


    /**
     *
     * @author <a href="https://leetcode.cn/u/affectionate-zhukovskybe6/">whichonetodo_32</a>
     * @date 2024/8/14 PM 2:47:55
     * @version 1.0.0
     * @description 感觉这样写更容易懂, 尤其是k - nums.size() + small.size()那边(https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/comments/2197476)
     * @filename KthLargestElementInAnArray.kt
     *
     */
    fun findKthLargest_2(nums: IntArray, k: Int): Int {

        return quickFind(nums.toList(), k)

    }


    private fun quickFind(nums: List<Int>, k: Int): Int {

        val pivot = nums[Random.nextInt(nums.size)]

        val small = mutableListOf<Int>()
        val equal = mutableListOf<Int>()
        val big = mutableListOf<Int>()

        for (num in nums) {

            if (num < pivot) {

                small.add(num)

            } else if (num == pivot) {

                equal.add(num)

            } else {

                big.add(num)

            }

        }

        return if (k <= big.size) {

            quickFind(big, k)

        } else if (k > big.size + equal.size) {

            quickFind(small, k - big.size - equal.size)

        } else {

            pivot

        }

    }


}