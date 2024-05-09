package day47

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/9 PM 10:48:36
 * @version 1.0.0
 * @description 展开二叉树为链表
 * @filename ExpandTheBinaryTreeIntoALinkedList.kt
 *
 */

/*
给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。*/

class Solution {


    /**
     *
     * @author <a href="https://space.bilibili.com/6400998">红桃A士</a>
     * @date 2024/5/9 PM 11:56:45
     * @version 1.0.0
     * @description 解法很哇塞
     * @filename ExpandTheBinaryTreeIntoALinkedList.kt
     *
     */
    fun flatten(root: TreeNode?): Unit {

        if (root == null || (root.left == null && root.right == null)) return

        root.left?.run {

            var temp = this
            while (temp.right != null) {

                temp = temp.right as TreeNode

            }
            temp.right = root.right
            root.right = this
            root.left = null

        }

        flatten(root.right)

    }


}