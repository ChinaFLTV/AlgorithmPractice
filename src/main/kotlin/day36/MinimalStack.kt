package day36

import java.util.*

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/26 PM 10:42:30
 * @version 1.0.0
 * @description 最小栈
 * @filename MinimalStack.kt
 *
 */

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。*/

class MinStack {


    private val minNodes = LinkedList<Node>()
    private val dummy_head = Node(-1, null, null)
    private val dummy_tail = Node(-1, null, null)
    private var count = 0


    init {

        minNodes.add(Node(Int.MAX_VALUE, null, null))
        dummy_head.next = dummy_tail
        dummy_tail.prev = dummy_head

    }


    fun push(`val`: Int) {

        val new_node = Node(`val`, null, null)

        val cur_actual_tail = dummy_tail.prev
        cur_actual_tail?.next = new_node
        dummy_tail.prev = new_node
        new_node.prev = cur_actual_tail
        new_node.next = dummy_tail

        minNodes.add(if (minNodes.last().`val` > new_node.`val`) new_node else minNodes.last())

        count++

    }


    fun pop() {

        if (count > 0) {

            val cur_actual_tail = dummy_tail.prev
            val new_actual_tail = dummy_tail.prev?.prev

            cur_actual_tail?.prev = null
            cur_actual_tail?.next = null

            new_actual_tail?.next = dummy_tail
            dummy_tail.prev = new_actual_tail

            minNodes.removeLast()

            count--

        }

    }


    fun top(): Int {

        if (count > 0) {

            return dummy_tail.prev!!.`val`

        } else {

            return -1

        }

    }


    fun getMin(): Int {

        return if (minNodes.size == 1) -1 else minNodes.last().`val`

    }


}

class Node(val `val`: Int, var prev: Node?, var next: Node?)

fun main() {

    val stack = MinStack()
    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    var min = stack.getMin()
    println(min)
    stack.pop()
    val top = stack.top()
    println(top)
    min = stack.getMin()
    println(min)

}