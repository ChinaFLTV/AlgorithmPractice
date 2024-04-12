package day21

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/11 下午 11:18:52
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

class ListNode(var `val`: Int) {


    var next: ListNode? = null


}

class Solution {


    fun hasCycle(head: ListNode?): Boolean {

        if (head?.next == null) {

            return false

        }

        var pointer = head
        var checkPointer: ListNode?

        while (pointer != null) {

            checkPointer = pointer.next
            while (checkPointer != null) {

                if (checkPointer.next == pointer) {

                    return true

                }

                checkPointer = checkPointer.next

            }
            pointer = pointer.next

        }

        return false

    }


}

fun main() {

    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    val hasCycle = Solution().hasCycle(node1)
    println(hasCycle)

}