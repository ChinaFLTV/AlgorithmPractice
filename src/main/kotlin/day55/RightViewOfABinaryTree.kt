package day55

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/18 PM 4:37:08
 * @version 1.0.0
 * @description 二叉树的右视图
 * @filename RightViewOfABinaryTree.kt
 *
 */

/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。*/


class Solution {


    private var list = ArrayList<Int>()
    private var deque = ArrayDeque<TreeNode>()
    private var count = 0


    fun rightSideView(root: TreeNode?): List<Int> {

        if (root == null) return list

        deque.addLast(root)
        count = 1

        while (count > 0) {

            var tempCount = 0

            lateinit var parent: TreeNode

            for (i in 1..count) {

                parent = deque.removeFirst()
                parent.left?.run {

                    deque.addLast(this)
                    tempCount++

                }
                parent.right?.run {

                    deque.addLast(this)
                    tempCount++

                }

            }

            list.add(parent.`val`)

            count = tempCount

        }

        return list

    }


}