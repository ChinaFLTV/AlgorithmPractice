package day31

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/21 PM 11:17:51
 * @version 1.0.0
 * @description 删除排序链表中的重复元素2
 * @filename RemoveDuplicateElementsFromASortedLinkedList.kt
 *
 */

/*
给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。*/

class Solution {


    fun deleteDuplicates(head: ListNode?): ListNode? {

        if (head?.next == null) {

            return head

        }

        val dummy = ListNode(0)
        // dummy.next = head

        var pre = dummy
        var cur = head

        while (cur != null) {

            if (cur.`val` != cur.next?.`val`) {

                pre.next = cur
                pre = cur
                cur = cur.next
                pre.next = null
                continue

            }

            while (cur != null && cur.`val` == cur.next?.`val`) {

                cur = cur.next

            }

            cur = cur?.next

        }

        return dummy.next

    }


}