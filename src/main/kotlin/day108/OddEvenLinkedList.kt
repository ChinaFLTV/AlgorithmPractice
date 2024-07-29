package day108

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/29 PM 7:11:06
 * @version 1.0.0
 * @description 奇偶链表
 * @filename OddEvenLinkedList.kt
 *
 */

/*
给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。

第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。

请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。

你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。*/

class Solution2 {


    fun oddEvenList(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        var oddPointer = head
        var evenPointer = head.next
        var pointer = evenPointer!!.next
        var idx = 3

        val oddHead = oddPointer
        val evenHead = evenPointer

        while (pointer != null) {

            if (idx % 2 == 0) {

                evenPointer!!.next = pointer
                evenPointer = evenPointer.next

            } else {

                oddPointer!!.next = pointer
                oddPointer = oddPointer.next

            }

            idx++
            pointer = pointer.next

        }

        oddPointer!!.next = evenHead
        evenPointer!!.next = null

        return oddHead

    }


}


fun main() {

    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    Solution2().oddEvenList(node1)

}