package day54

import day38.TreeNode
import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/17 PM 11:09:14
 * @version 1.0.0
 * @description 完全二叉树的节点个数
 * @filename TheNumberOfNodesInACompleteBinaryTree.kt
 *
 */

/*
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。*/


class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/zuo-10/">左</a>
     * @date 2024/5/17 PM 11:20:13
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/count-complete-tree-nodes/solutions/181466/c-san-chong-fang-fa-jie-jue-wan-quan-er-cha-shu-de/?envType=study-plan-v2&envId=top-interview-150">思路来源</a>
     * @filename TheNumberOfNodesInACompleteBinaryTree.kt
     *
     */
    fun countNodes_answer_1(root: TreeNode?): Int {

        if (root == null) return 0

        val leftTreeHeight = calculateTreeHeight(root.left)
        val rightTreeHeight = calculateTreeHeight(root.right)

        if (leftTreeHeight == rightTreeHeight) {

            return (1 shl leftTreeHeight) + countNodes_answer_1(root.right)

        } else {

            return countNodes_answer_1(root.left) + (1 shl rightTreeHeight)

        }


    }


    private fun calculateTreeHeight(root: TreeNode?): Int {

        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        return 1 + max(calculateTreeHeight(root.left), calculateTreeHeight(root.right))

    }


}