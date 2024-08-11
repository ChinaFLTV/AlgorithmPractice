package day112

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/11 PM 1:18:36
 * @version 1.0.0
 * @description 两两交换链表中的节点
 * @filename SwapNodesInPairs.kt
 *
 */

/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/guanpengchn/">画手大鹏</a>
     * @date 2024/8/11 PM 1:54:14
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/7058/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/">画解算法：24. 两两交换链表中的节点</a>
     * @filename SwapNodesInPairs.kt
     *
     */
    fun swapPairs(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        val next = head.next

        head.next = swapPairs(next?.next)
        next?.next = head

        return next

    }


}