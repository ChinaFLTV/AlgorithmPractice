package day118

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/19 PM 3:36:21
 * @version 1.0.0
 * @description K 个一组翻转链表
 * @filename ReverseNodesInKGroup.kt
 *
 */

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯地改变节点内部的值，而是需要实际进行节点交换。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：



输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]


提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000


进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？*/

class Solution2 {


    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        val dummy = ListNode(-1)
        dummy.next = head

        var prev: ListNode? = dummy
        var end: ListNode? = dummy

        while (end?.next != null) {

            for (i in 1..k)
                end = end?.next

            if (end == null)
                break

            val oldStart = prev?.next
            val nextStart = end.next
            end.next = null
            val newStart = reverse(oldStart)

            prev?.next = newStart
            oldStart?.next = nextStart

            prev = oldStart
            end = oldStart

        }

        return dummy.next

    }


    private fun reverse(head: ListNode?): ListNode? {

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


}