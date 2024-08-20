package day119

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/20 PM 4:34:34
 * @version 1.0.0
 * @description 合并两个有序链表
 * @filename MergeTwoSortedList.kt
 *
 */

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]


提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列*/

class Solution {


    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        if (list1 == null)
            return list2

        if (list2 == null)
            return list1

        var p1 = list1
        var p2 = list2

        val dummy = ListNode(-101)
        var p3 = dummy

        while (p1 != null && p2 != null) {

            if (p1.`val` <= p2.`val`) {

                val next = p1.next
                p1.next = null
                p3.next = p1

                p1 = next
                p3 = p3.next!!

            } else {

                val next = p2.next
                p2.next = null
                p3.next = p2

                p2 = next
                p3 = p3.next!!

            }

        }

        if (p1 == null)
            p3.next = p2

        if (p2 == null)
            p3.next = p1

        return dummy.next

    }


}