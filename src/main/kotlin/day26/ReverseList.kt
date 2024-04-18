package day26

import day24.ListNode
import day25.Solution

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/16 PM 10:48:12
 * @version 1.0.0
 * @description 反转链表1
 * @filename ReverseList.kt
 *
 */

class Solution {


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/16 PM 10:49:56
     * @version 1.0.0
     * @description 递归
     * @filename ReverseList.kt
     *
     */
    fun reverse(head: ListNode?): ListNode? {

        if (head?.next == null) {

            return head

        }

        return reverseList(null, head, head.next)

    }


    private fun reverseList(prev: ListNode?, cur: ListNode?, next: ListNode?): ListNode? {

        if (cur == null) {

            return prev

        }

        var prevPointer = prev
        var curPointer = cur
        var nextPointer = next


        curPointer.next = prevPointer

        prevPointer = curPointer
        curPointer = nextPointer
        nextPointer = nextPointer?.next

        return reverseList(prevPointer, curPointer, nextPointer)

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