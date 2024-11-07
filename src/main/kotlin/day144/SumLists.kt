package day144

import day107.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/7 PM 12:50:49
 * @version 1.0.0
 * @description 链表求和
 * @filename SumLists.kt
 *
 */

/*
给定两个用链表表示的整数，每个节点包含一个数位。

这些数位是反向存放的，也就是个位排在链表首部。

编写函数对这两个整数求和，并用链表形式返回结果。



示例：

输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912
进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?

示例：

输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912*/

class Solution {


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null)
            return l2
        if (l2 == null)
            return l1

        val head = ListNode(0)
        var cur = head
        var l1p = l1
        var l2p = l2

        while (l1p != null || l2p != null) {

            val carry = ((l1p?.`val` ?: 0) + (l2p?.`val` ?: 0) + cur.`val`) / 10
            cur.`val` = ((l1p?.`val` ?: 0) + (l2p?.`val` ?: 0) + cur.`val`) % 10

            l1p = l1p?.next
            l2p = l2p?.next

            if (l1p != null || l2p != null || carry > 0) {

                cur.next = ListNode(carry)
                cur = cur.next!!

            }

        }

        return head

    }


}


fun main() {

    val l11 = ListNode(2)
    val l12 = ListNode(4)
    val l13 = ListNode(3)

    val l21 = ListNode(5)
    val l22 = ListNode(6)
    val l23 = ListNode(4)

    l11.next = l12
    l12.next = l13

    l21.next = l22
    l22.next = l23

    Solution().addTwoNumbers(l11, l21)

}