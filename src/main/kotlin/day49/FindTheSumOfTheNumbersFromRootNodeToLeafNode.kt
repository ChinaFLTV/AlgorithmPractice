package day49

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/11 PM 10:57:03
 * @version 1.0.0
 * @description 求根节点到叶节点的数字之和
 * @filename FindTheSumOfTheNumbersFromRootNodeToLeafNode.kt
 *
 */

/*
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。*/

class Solution {


    fun sumNumbers(root: TreeNode?): Int {

        val queue1 = ArrayDeque<Int>()
        val queue2 = ArrayDeque<TreeNode>()
        var count = 1
        queue2.addLast(root!!)

        while (count != 0) {

            var tempCount = 0

            for (i in 1..count) {

                val parent = queue2.removeFirst()
                parent.left?.run {

                    `val` = "${parent.`val`}${`val`}".toInt()
                    queue2.addLast(this)
                    tempCount++

                }
                parent.right?.run {

                    `val` = "${parent.`val`}${`val`}".toInt()
                    queue2.addLast(this)
                    tempCount++

                }

                if (parent.left == null && parent.right == null) {

                    queue1.addLast(parent.`val`)

                }

            }

            count = tempCount

        }

        return queue1.sum()

    }


    private var sum = 0


    /**
     *
     * @author <a href="https://space.bilibili.com/320530935?spm_id_from=333.788.0.0">睡不醒的鲤鱼</a>
     * @date 2024/5/11 PM 11:31:00
     * @version 1.0.0
     * @description 深度优先遍历
     * @filename FindTheSumOfTheNumbersFromRootNodeToLeafNode.kt
     *
     */
    fun sumNumbers_answer_1(root: TreeNode?): Int {

        dfs(root!!, 0)
        return sum

    }


    private fun dfs(root: TreeNode, num: Int) {

        val tempNum = num * 10 + root.`val`
        if (root.left == null && root.right == null) sum += tempNum
        root.left?.run {

            dfs(this, tempNum)

        }
        root.right?.run {

            dfs(this, tempNum)

        }

    }


}


fun main() {

    val treeNode1 = TreeNode(1)
    val treeNode2 = TreeNode(2)
    val treeNode3 = TreeNode(3)
    treeNode1.left = treeNode2
    treeNode1.right = treeNode3

    Solution().sumNumbers(treeNode1)

}