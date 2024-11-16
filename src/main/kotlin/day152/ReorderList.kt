package day152

import day107.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/16 PM 2:56:07
 * @version 1.0.0
 * @description 143. 重排链表
 * @filename ReorderList.kt
 *
 */

/*
给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



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


    private fun reorderList(head: ListNode?) {

        if (head?.next == null)
            return

        val mid = getMiddleNode(head)
        var rightHead = mid.next
        mid.next = null

        rightHead = reverseList(rightHead)
        mergeList(head, rightHead)

    }


    private fun getMiddleNode(head: ListNode): ListNode {

        var slow = head
        var fast = head

        while (slow.next != null && fast.next?.next != null) {

            slow = slow.next as ListNode
            fast = fast.next?.next as ListNode

        }

        return slow

    }

    private fun reverseList(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        var prev: ListNode? = null
        var cur: ListNode? = head


        while (cur != null) {

            val next = cur.next

            cur.next = prev
            prev = cur
            cur = next

        }

        return prev!!

    }


    private fun mergeList(left: ListNode, right: ListNode?) {

        if (right == null)
            return

        var lp1: ListNode? = left
        var lp2: ListNode? = right

        while (lp1 != null && lp2 != null) {

            val lp1Next = lp1.next
            val lp2Next = lp2.next

            lp1.next = lp2
            lp2.next = lp1Next


            lp1 = lp1Next
            lp2 = lp2Next

        }

    }


}