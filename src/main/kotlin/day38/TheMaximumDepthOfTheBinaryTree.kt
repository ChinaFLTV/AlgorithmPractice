package day38

import kotlin.math.max

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/28 PM 10:52:07
 * @version 1.0.0
 * @description 二叉树的最大深度
 * @filename TheMaximumDepthOfTheBinaryTree.kt
 *
 */

/*
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。*/

class Solution {


    fun maxDepth(root: TreeNode?): Int {

        if (root == null) {

            return 0

        }

        return treeWalk(root, 1)

    }


    private fun treeWalk(node: TreeNode?, depth: Int): Int {

        if (node == null) {

            return depth - 1

        }

        return max(treeWalk(node.left, depth + 1), treeWalk(node.right, depth + 1))

    }


}


class TreeNode(val `val`: Int) {


    var left: TreeNode? = null
    var right: TreeNode? = null


}