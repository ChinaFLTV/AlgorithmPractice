package day46

import day45.Node

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/8 PM 11:40:05
 * @version 1.0.0
 * @description FillTheNextRightNodePointerForEachNode.kt
 * @filename FillTheNextRightNodePointerForEachNode.kt
 *
 */

/*给定一个二叉树：

struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。

初始状态下，所有 next 指针都被设置为 NULL 。*/

class Solution {


    private val queue = ArrayDeque<Node>()
    private var count = 0


    /**
     *
     * @author <a href="https://space.bilibili.com/525438321?spm_id_from=333.337.search-card.all.click">代码随想录</a>
     * @date 2024/5/9 AM 12:07:27
     * @version 1.0.0
     * @description 层序遍历
     * @filename FillTheNextRightNodePointerForEachNode.kt
     *
     */
    fun connect(root: Node?): Node? {

        if (root == null) {

            return root

        }

        queue.addLast(root)
        count = 1

        while (true) {

            if (count == 0) {

                break

            }

            var tempCount = 0

            for (i in 1..count) {

                val parentNode = queue.removeFirst()
                parentNode.next = if (i == count) null else queue.firstOrNull()

                if (parentNode.left != null) {

                    queue.addLast(parentNode.left as Node)
                    tempCount++

                }
                if (parentNode.right != null) {

                    queue.addLast(parentNode.right)
                    tempCount++

                }

            }

            count = tempCount

        }

        return root

    }


}