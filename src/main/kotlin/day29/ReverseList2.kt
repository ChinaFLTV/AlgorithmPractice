package day29

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/19 PM 11:18:04
 * @version 1.0.0
 * @description 反转链表2
 * @filename ReverseList2.kt
 *
 */

class Solution {


    /**
     *
     * @author 贾卷积
     * @date 2024/4/19 PM 11:35:06
     * @version 1.0.0
     * @description 双指针头插法
     * @filename ReverseList2.kt
     *
     */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        if (head!!.next == null || left == right) {

            return head

        }

        val dummy = ListNode(0)
        dummy.next = head
        var g = dummy
        var p = g.next

        for (i in 1..<left) {

            g = p!!
            p = p.next

        }

        for (i in 1..right - left) {

            val removed = p!!.next
            p.next = removed!!.next
            removed.next = g.next
            g.next = removed

        }

        return dummy.next

    }


}