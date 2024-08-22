package day121

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/22 PM 3:19:15
 * @version 1.0.0
 * @description 重排链表
 * @filename ReorderList.kt
 *
 */

/*
给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯地改变节点内部的值，而是需要实际的进行节点交换。



示例 1：



输入：head = [1,2,3,4]
输出：[1,4,2,3]
示例 2：



输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3]


提示：

链表的长度范围为 [1, 5 * 104]
1 <= node.val <= 1000*/

class Solution {


    /**
     *
     * @author 力扣官方
     * @date 2024/8/22 PM 3:41:44
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/reorder-list/solutions/452867/zhong-pai-lian-biao-by-leetcode-solution/">重排链表</a>
     * @filename ReorderList.kt
     *
     */
    fun reorderList(head: ListNode?) {

        if (head?.next == null)
            return

        val mid = getMiddleNode(head)
        val rightHead = mid.next
        mid.next = null
        val reversedRightHalf = reverseList(rightHead)
        mergeList(head, reversedRightHalf)

    }


    private fun getMiddleNode(head: ListNode): ListNode {

        var slow: ListNode = head
        var fast: ListNode? = head

        while (slow.next != null && fast?.next?.next != null) {

            slow = slow.next!!
            fast = fast.next?.next

        }

        return slow

    }


    private fun reverseList(head: ListNode?): ListNode? {

        if (head == null)
            return null

        var prev: ListNode? = null
        var cur: ListNode? = head

        while (cur != null) {

            val next = cur.next
            cur.next = prev

            prev = cur
            cur = next

        }

        return prev

    }


    private fun mergeList(l1: ListNode?, l2: ListNode?) {

        if (l1 == null || l2 == null)
            return

        var lp1: ListNode? = l1
        var lp2: ListNode? = l2

        while (lp1 != null && lp2 != null) {

            val l1Next = lp1.next
            val l1NextNext = l1Next?.next
            val l2Next = lp2.next
            val l2NextNext = l2Next?.next

            lp1.next = lp2
            lp2.next = l1Next

            l1Next?.next = l2Next
            l2Next?.next = l1NextNext

            lp1 = l1NextNext
            lp2 = l2NextNext

        }

    }

}