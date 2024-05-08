package day45

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/6 PM 10:48:23
 * @version 1.0.0
 * @description 填充每个节点的下一个右侧节点指针
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


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/5/6 PM 11:36:10
     * @version 1.0.0
     * @description
     * @filename FillTheNextRightNodePointerForEachNode.kt
     *
     */
    fun connect(root: Node?): Node? {

        if (root?.left == null && root?.right == null) {

            return root

        }

        var temp = root.next
        if (root.left != null) {

            root.left!!.next = root.right
            while (root.left!!.next == null && temp != null) {

                root.left!!.next = temp.left ?: temp.right
                temp = temp.next

            }

        }
        if (root.right != null) {

            temp = root.next
            while (root.right!!.next == null && temp != null) {

                root.right!!.next = temp.left ?: temp.right
                temp = temp.next

            }

        }

        connect(root.left)
        connect(root.right)

        return root

    }


}


class Node(val `val`: Int) {


    var left: Node? = null
    val right: Node? = null
    var next: Node? = null


}