package day25

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/15 PM 11:13:10
 * @version 1.0.0
 * @description 反转链表1
 * @filename ReverseList1.kt
 *
 */

class Solution {


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/15 PM 11:49:26
     * @version 1.0.0
     * @description 三指针遍历
     * @filename ReverseList1.kt
     *
     */
    fun reverse(head: ListNode?): ListNode? {

        if (head?.next == null) {

            return head

        }

        var prevPointer: ListNode? = null
        var curPointer: ListNode? = head
        var nextPointer: ListNode? = head.next

        while (curPointer != null) {

            curPointer.next = prevPointer

            prevPointer = curPointer
            curPointer = nextPointer
            nextPointer = nextPointer?.next // 2024-4-15  23:47-模糊处理

        }

        return prevPointer

    }


}


fun main() {

    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = null

    printNodeList(node1)
    printNodeList(Solution().reverse(node1))

}


fun printNodeList(head: ListNode?) {

    var pointer = head
    while (pointer != null) {

        print("${pointer.`val`}\t\t")
        pointer = pointer.next

    }
    println()

}