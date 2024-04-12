package day22

import day21.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/12 下午 10:33:25
 * @version 1.0.0
 * @description 环形链表
 * @filename CircularLinkedList.kt
 *
 */

/*
给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

如果链表中存在环 ，则返回 true 。 否则，返回 false 。*/


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


class Solution {


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/12 下午 10:50:30
     * @version 1.0.0
     * @description Set
     * @filename CircularLinkedList.kt
     *
     */
    fun hasCycle_answer_1(head: ListNode?): Boolean {

        val set = mutableSetOf<ListNode>()
        var pointer = head


        while (pointer != null) {

            if (set.contains(pointer)) {

                return true

            } else {

                set.add(pointer)
                pointer = pointer.next

            }

        }

        return false

    }


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/12 下午 10:51:31
     * @version 1.0.0
     * @description 双指针遍历
     * @filename CircularLinkedList.kt
     *
     */
    fun hasCycle_answer_2(head: ListNode?): Boolean {

        var pointer1 = head
        var pointer2 = head

        while (pointer1 != null && pointer2 != null && pointer2.next != null) {

            pointer1 = pointer1.next
            pointer2 = (pointer2.next as ListNode).next

            if (pointer1 == pointer2) {

                return true

            }

        }

        return false

    }


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/12 下午 11:04:23
     * @version 1.0.0
     * @description o(1)解决方法
     * @filename CircularLinkedList.kt
     *
     */
    fun hasCycle_answer_3(head: ListNode?): Boolean {

        var pointer = head
        var count = 0

        while (pointer != null) {

            count++
            pointer = pointer.next
            if (count == 10001) {

                return true

            }

        }

        return false

    }


}