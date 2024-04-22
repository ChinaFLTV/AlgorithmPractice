package day32

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/22 PM 10:26:43
 * @version 1.0.0
 * @description 旋转链表
 * @filename RotateLinkedList.kt
 *
 */

/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。*/

class Solution {


    fun rotateRight(oldHead: ListNode?, k: Int): ListNode? {

        if (oldHead?.next == null) {

            return oldHead

        }

        var head = oldHead
        var pre = oldHead
        var tail = pre.next

        while (tail?.next != null) {

            pre = tail
            tail = tail.next

        }

        for (i in 1..k) {

            pre?.next = null
            tail?.next = head

            head = tail
            tail = pre

            pre = head
            while (pre?.next != tail) {

                pre = pre?.next

            }

        }

        return head

    }


    /**
     *
     * @author <a href="https://leetcode.cn/u/gallianoo/">Gallianoo</a>
     * @date 2024/4/22 PM 11:39:03
     * @version 1.0.0
     * @description
     * @filename RotateLinkedList.kt
     *
     */
    fun rotateRight_answer_1(oldHead: ListNode?, k: Int): ListNode? {

        if (oldHead?.next == null) return oldHead

        var count: Int = 1
        var temp = oldHead

        while (temp?.next != null) {

            temp = temp.next
            count++

        }

        temp?.next = oldHead

        for (i in 1..count - k % count) {

            temp = temp?.next

        }

        val newHead = temp?.next
        temp?.next = null

        return newHead

    }


}