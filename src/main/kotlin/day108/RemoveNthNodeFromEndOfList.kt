package day108

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/29 PM 4:46:03
 * @version 1.0.0
 * @description 删除链表的倒数第 N 个结点
 * @filename RemoveNthNodeFromEndOfList.kt
 *
 */

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/guanpengchn/">画手大鹏</a>
     * @date 2024/7/29 PM 4:52:07
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/7803/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/">画解算法：19. 删除链表的倒数第N个节点</a>
     * @filename RemoveNthNodeFromEndOfList.kt
     *
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        val dummy = ListNode(-1)
        dummy.next = head

        var fast: ListNode? = dummy
        var slow = dummy

        for (i in 1..n) {

            fast = fast?.next

        }

        while (fast?.next != null) {

            fast = fast.next
            slow = slow.next!!

        }

        slow.next = slow.next?.next

        return dummy.next

    }


}