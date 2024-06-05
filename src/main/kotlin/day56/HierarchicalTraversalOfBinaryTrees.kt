package day56

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/19 PM 5:33:02
 * @version 1.0.0
 * @description 二叉树的层序遍历
 * @filename HierarchicalTraversalOfBinaryTrees.kt
 *
 */

/*
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。*/

class Solution1 {


    private val deque = ArrayDeque<TreeNode>()
    private var count = 0
    private val list = ArrayList<List<Int>>()


    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) return list

        deque.addLast(root)
        count = 1

        while (count > 0) {

            var tempCount = 0
            val subList = ArrayList<Int>()

            for (i in 1..count) {

                val parent = deque.removeFirst()
                parent.left?.run {

                    deque.addLast(this)
                    tempCount++

                }
                parent.right?.run {

                    deque.addLast(this)
                    tempCount++

                }
                subList.add(parent.`val`)

            }

            list.add(subList)

            count = tempCount


        }

        return list

    }


}