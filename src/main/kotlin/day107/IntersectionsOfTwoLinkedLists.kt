package day107

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/7/28 PM 3:28:13
 * @version 1.0.0
 * @description 相交链表
 * @filename IntersectionsOfTwoLinkedLists.kt
 *
 */

/*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

图示两个链表在节点 c1 开始相交：



题目数据 保证 整个链式结构中不存在环。

注意，函数返回结果后，链表必须 保持其原始结构 。

自定义评测：

评测系统 的输入如下（你设计的程序 不适用 此输入）：

intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。*/

class ListNode(var `val`: Int) {


    var next: ListNode? = null


}


class Solution2 {


    /**
     *
     * @author <a href="https://leetcode.cn/u/reals/">房建斌学算法</a>
     * @date 2024/7/28 PM 4:00:03
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/10774/tu-jie-xiang-jiao-lian-biao-by-user7208t/">图解相交链表</a>
     * @filename IntersectionsOfTwoLinkedLists.kt
     *
     */
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

        if (headA == null || headB == null)
            return null

        var pointerA = headA
        var pointerB = headB

        while (pointerA != pointerB) {

            pointerA = if (pointerA == null) headB else pointerA.next
            pointerB = if (pointerB == null) headA else pointerB.next

        }

        return pointerA

    }


}