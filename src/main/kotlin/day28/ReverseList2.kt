package day28

import day24.ListNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/18 PM 10:54:36
 * @version 1.0.0
 * @description 翻转链表2
 * @filename ReverseList2.kt
 *
 */


class Solution {


    /**
     *
     * @author Lenovo/LiGuanda
     * @date 2024/4/18 PM 10:55:25
     * @version 1.0.0
     * @description 数组+Map(该方法仅在元素数值互不相同的时候可行)
     * @filename ReverseList2.kt
     *
     */
    fun reverseBetween(head: ListNode?, leftVal: Int, rightVal: Int): ListNode? {

        if (head?.next == null || leftVal == rightVal) {

            return head

        }

        val arr = mutableListOf<Int>()
        val map = mutableMapOf<Int, ListNode?>()
        var temp = head
        var left = leftVal - 1
        var right = rightVal - 1

        while (temp != null) {

            arr.add(temp.`val`)
            map[temp.`val`] = temp

            temp = temp.next

        }

        var tem: Int
        while (left < right) {

            tem = arr[left]
            arr[left] = arr[right]
            arr[right] = tem

            left++
            right--

        }

        for (i in 0..arr.size - 2) {

            map[arr[i]]!!.next = map[arr[i + 1]]

        }

        map[arr[arr.size - 1]]!!.next = null

        return map[arr[0]]

    }


}


fun main() {

    val node1 = ListNode(-3)
    val node2 = ListNode(-2)
    val node3 = ListNode(3)
    val node4 = ListNode(-5)
    val node5 = ListNode(3)
    val node6 = ListNode(4)
    val node7 = ListNode(-4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = null

    printNodeList(node1)
    printNodeList(day28.Solution().reverseBetween(node1, 5, 7))

}


fun printNodeList(head: ListNode?) {

    var pointer = head
    while (pointer != null) {

        print("${pointer.`val`}\t\t")
        pointer = pointer.next

    }
    println()

}