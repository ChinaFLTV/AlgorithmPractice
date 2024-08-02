package day111

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/2 PM 4:43:09
 * @version 1.0.0
 * @description 排序链表
 * @filename SortList.kt
 *
 */

/*给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。*/

class Solution {


    /*fun sortList(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        val map = hashMapOf<Int, ListNode>()

        var pointer = head

        while (pointer != null) {

            val nextPointer = pointer.next

            if (map.containsKey(pointer.`val`)) {

                pointer.next = map[pointer.`val`]
                map[pointer.`val`] = pointer

            } else {

                map[pointer.`val`] = pointer
                map[pointer.`val`]?.next = null

            }

            pointer = nextPointer

        }

        val dummy = ListNode(10_0001)

        var prevSublist = dummy

        for (entry in map.entries) {

            prevSublist.next = entry.value
            var pointer = entry.value
            while (pointer.next != null) {

                pointer = pointer.next as ListNode

            }

            prevSublist = pointer

        }

        return dummy.next

    }*/


    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     * @date 2024/8/2 PM 5:35:30
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/?envType=study-plan-v2&envId=top-interview-150">Sort List （归并排序链表）</a>
     * @filename SortList.kt
     *
     */
    fun sortList(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        var slow = head
        var fast = head.next

        while (fast?.next != null) {

            slow = slow?.next
            fast = fast.next?.next

        }

        val rightHead = slow?.next
        slow?.next = null

        var left = sortList(head)
        var right = sortList(rightHead)

        val dummy = ListNode(10_001)
        var pointer = dummy

        while (left != null && right != null) {

            if (left.`val` < right.`val`) {

                pointer.next = left
                left = left.next

            } else {

                pointer.next = right
                right = right.next

            }

            pointer = pointer.next as ListNode

        }

        if (left == null)
            pointer.next = right
        else
            pointer.next = left

        return dummy.next

    }


}