package day24

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/14 下午 11:14:56
 * @version 1.0.0
 * @description 反转链表2
 * @filename ReverseList.kt
 *
 */

class ListNode(var `val`: Int) {


    var next: ListNode? = null


}


class Solution {


    /*fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        if (left == right || head!!.next == null) return head

        var startPointer: ListNode? = null
        var endPointer: ListNode? = null
        var prevPointer: ListNode? = null

        var temp = head
        while (temp != null) {

            if (temp.`val` == left && startPointer == null) {

                startPointer = temp

            }

            if (temp.`val` == right) {

                endPointer = temp

            }

            temp = temp.next

        }

        if (startPointer == null || endPointer == null) return head


    }*/


}