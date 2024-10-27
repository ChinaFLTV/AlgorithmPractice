package day137

import day107.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/27 PM 4:17:49
 * @version 1.0.0
 * @description 反转链表
 * @filename ReverseLinkedList.kt
 *
 */

/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]


提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000


进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？*/

class Solution {


    fun reverseList(head: ListNode?): ListNode? {

        if (head?.next == null)
            return head

        val dummy = ListNode(-1)
        dummy.next = head

        reverse(dummy, dummy.next!!, dummy.next?.next)

        return dummy.next

    }


    private fun reverse(dummy: ListNode, tail: ListNode, cur: ListNode?) {

        if (cur == null)
            return

        val next = cur.next

        tail.next = next
        cur.next = dummy.next
        dummy.next = cur

        reverse(dummy, tail, tail.next)

    }


}