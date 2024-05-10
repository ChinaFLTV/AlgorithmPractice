package day48

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/10 PM 11:12:55
 * @version 1.0.0
 * @description 路径总和
 * @filename PathSummation.kt
 *
 */

/*
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。*/

class Solution {


    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {

        if (root == null) {

            return false

        }

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        var count = 1

        while (count != 0) {

            var tempCount = 0

            for (i in 1..count) {

                val parent = queue.removeFirst()
                parent.left?.run {

                    `val` += parent.`val`
                    queue.addLast(this)
                    tempCount++

                }
                parent.right?.run {

                    `val` += parent.`val`
                    queue.addLast(this)
                    tempCount++

                }

                if (parent.left == null && parent.right == null && parent.`val` == targetSum) return true

            }
            count = tempCount

        }

        return false

    }


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/5/10 PM 11:38:24
     * @version 1.0.0
     * @description 递归写法
     * @filename PathSummation.kt
     *
     */
    fun hasPathSum_answer_1(root: TreeNode?, targetSum: Int): Boolean {

        if (root == null) return false

        if (root.left == null && root.right == null) return root.`val` == targetSum

        return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)

    }


}