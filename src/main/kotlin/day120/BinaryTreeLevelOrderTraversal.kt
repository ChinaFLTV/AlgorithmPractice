package day120

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/8/21 PM 1:55:55
 * @version 1.0.0
 * @description 二叉树的层序遍历
 * @filename BinaryTreeLevelOrderTraversal.kt
 *
 */

/*
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]


提示：

树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000*/

class Solution {


    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null)
            return arrayListOf()

        val deque = ArrayDeque<TreeNode>()

        deque.addLast(root)
        var count = 1
        val res = arrayListOf(arrayListOf(root.`val`))

        while (count > 0) {

            var newCount = 0
            val newArrayList = arrayListOf<Int>()

            for (i in 1..count) {

                val parent = deque.removeFirst()
                parent.left?.run {

                    deque.addLast(this)
                    newArrayList.add(`val`)
                    newCount++

                }

                parent.right?.run {

                    deque.addLast(this)
                    newArrayList.add(`val`)
                    newCount++

                }

            }

            count = newCount
            if (count > 0)
                res.add(newArrayList)

        }

        return res

    }


}