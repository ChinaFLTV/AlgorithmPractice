package day136

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/26 PM 2:02:44
 * @version 1.0.0
 * @description 用队列实现栈
 * @filename ImplementStacksUsingQueues.kt
 *
 */

/*
请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。


注意：

你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。


示例：

输入：
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 2, 2, false]

解释：
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // 返回 2
myStack.pop(); // 返回 2
myStack.empty(); // 返回 False


提示：

1 <= x <= 9
最多调用100 次 push、pop、top 和 empty
每次调用 pop 和 top 都保证栈不为空


进阶：你能否仅用一个队列来实现栈。*/

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/26 PM 2:24:51
 * @version 1.0.0
 * @description 参考自 : https://programmercarl.com/0225.%E7%94%A8%E9%98%9F%E5%88%97%E5%AE%9E%E7%8E%B0%E6%A0%88.html#%E6%80%9D%E8%B7%AF
 * @filename ImplementStacksUsingQueues.kt
 *
 */
/*
class MyStack {


    private val queue1 = LinkedBlockingQueue<Int>()
    private val queue2 = LinkedBlockingQueue<Int>()


    fun push(x: Int) {

        queue1.add(x)

    }


    fun pop(): Int {

        while (queue1.size > 1) {

            queue2.add(queue1.remove())

        }

        val res: Int = if (queue1.isEmpty()) -1 else queue1.remove()

        while (queue2.isNotEmpty()) {

            queue1.add(queue2.remove())

        }

        return res

    }


    fun top(): Int {

        while (queue1.size > 1) {

            queue2.add(queue1.remove())

        }

        val res: Int = if (queue1.isEmpty()) {

            -1

        } else {

            val temp = queue1.remove()
            queue2.add(temp)

            temp

        }

        while (queue2.isNotEmpty()) {

            queue1.add(queue2.remove())

        }

        return res

    }


    fun empty() = queue1.isEmpty()


}*/


class MyStack {


    private val queue = arrayListOf<Int>()


    fun push(x: Int) {

        queue.add(x)

    }


    fun pop(): Int {

        if (queue.isEmpty())
            return -1

        for (i in 1..<queue.size) {

            queue.add(queue.removeFirst())

        }

        return queue.removeFirst()

    }


    fun top(): Int {

        if (queue.isEmpty())
            return -1

        for (i in 1..<queue.size) {

            queue.add(queue.removeFirst())

        }

        val temp = queue.first()

        queue.add(queue.removeFirst())

        return temp

    }


    fun empty() = queue.isEmpty()


}