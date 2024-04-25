package day33

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/23 PM 10:42:37
 * @version 1.0.0
 * @description 分隔链表
 * @filename SeparateLinkedList.kt
 *
 */

/*
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。*/

class Solution {


    fun partition(head: ListNode?, x: Int): ListNode? {

        if (head?.next == null) {

            return head

        }

        val dummy1 = ListNode(0)
        val dummy2 = ListNode(x)

        var temp1 = dummy1
        var temp2 = dummy2

        var temp = head
        var next: ListNode?
        while (temp != null) {

            next = temp.next
            temp.next = null

            if (temp.`val` < x) {

                temp1.next = temp
                temp1 = temp1.next as ListNode

            } else {

                temp2.next = temp
                temp2 = temp2.next as ListNode

            }

            temp = next

        }

        temp1.next = dummy2.next

        return dummy1.next

    }


}


fun main() {

    val node1 = ListNode(1)
    val node2 = ListNode(4)
    val node3 = ListNode(3)
    val node4 = ListNode(2)
    val node5 = ListNode(5)
    val node6 = ListNode(2)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = null

    printNodeList(node1)
    printNodeList(Solution().partition(node1, 3))

}


fun printNodeList(head: ListNode?) {

    var pointer = head
    while (pointer != null) {

        print("${pointer.`val`}\t\t")
        pointer = pointer.next

    }
    println()

}