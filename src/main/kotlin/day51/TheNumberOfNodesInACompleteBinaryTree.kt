package day51

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/13 PM 11:05:15
 * @version 1.0.0
 * @description 完全二叉树的节点个数
 * @filename TheNumberOfNodesInACompleteBinaryTree.kt
 *
 */

/*
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。*/

class Solution {


    private var count = 0


    fun countNodes(root: TreeNode?): Int {

        traversal(root)
        return count

    }


    private fun traversal(root: TreeNode?) {

        if (root == null) return
        if (root.left == null && root.right == null) {

            count++
            return

        }

        root.left?.run {

            traversal(this)

        }
        count++
        root.right?.run {

            traversal(this)

        }

    }


    fun countNodes_answer_1(root: TreeNode?): Int {

        if (root == null) return 0
        var leftHeight = 0
        var rightHeight = 0
        var leftTemp = root.left
        var rightTemp = root.right
        while (leftTemp != null) {

            leftTemp = leftTemp.left
            leftHeight++

        }
        while (rightTemp != null) {

            rightTemp = rightTemp.right
            rightHeight++

        }
        if (leftHeight == rightHeight) return (1 shl (leftHeight as Int + 1)) - 1

        return 123546879 // shuffle result , don't take it seriously

    }


}