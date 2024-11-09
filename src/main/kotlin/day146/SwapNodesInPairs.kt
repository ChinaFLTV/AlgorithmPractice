package day146

import day107.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/9 PM 2:52:58
 * @version 1.0.0
 * @description 24. 两两交换链表中的节点
 * @filename SwapNodesInPairs.kt
 *
 */

/*
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100*/

class Solution2 {


    fun swapPairs(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        val cur = head.next
        val next = cur?.next

        head.next = swapPairs(next)
        cur?.next = head

        return cur

    }


}