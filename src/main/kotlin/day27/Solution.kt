package day27

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/17 PM 11:00:06
 * @version 1.0.0
 * @description 反转链表2
 * @filename Solution2.kt
 *
 */


class Solution {


    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        if (head?.next == null) {

            return head

        }

        var prevEnd: ListNode? = null
        var postEnd: ListNode? = null
        var isNeedReverse = false
        var reverseCount = 0
        var isFoundPrevEnd = false

        var temp = head

        while (temp != null) {

            if (temp.`val` == left && prevEnd == null) {


                isFoundPrevEnd = true

            }

            if (isNeedReverse) {

                reverseCount++

            }

            if ((temp.next as ListNode).`val` == right) {

                postEnd = temp.next
                isNeedReverse = false

            }

        }

        if (reverseCount <= 1) {

            return head

        }

        return null


    }


}