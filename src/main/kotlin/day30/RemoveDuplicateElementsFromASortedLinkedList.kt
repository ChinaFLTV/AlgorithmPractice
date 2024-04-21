package day30

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/20 PM 10:38:55
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

        val map = LinkedHashMap<Int, ListNode?>()

        var p = head

        while (p != null) {

            if (map.containsKey(p.`val`)) {

                map[p.`val`] = null

            } else {

                map[p.`val`] = p

            }

            p = p.next

        }

        p = ListNode(0)
        val dummy = p
        map.forEach { (_, node) ->

            if (node != null) {

                node.next = null
                p!!.next = node
                p = p!!.next

            }

        }

        return dummy.next

    }


}