package day44

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/5 PM 10:46:45
 * @version 1.0.0
 * @description 从中序和后序遍历序列构造二叉树
 * @filename ConstructBinaryTreeFromInOrderAndPostOrderTraversal.kt
 *
 */

/*
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。*/

class Solution {


    private lateinit var inorderPosMap: Map<Int, Int>


    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {

        inorderPosMap = inorder.withIndex().associate { it.value to it.index }

        return recursiveBuildTree(inorder, postorder, 0, inorder.size - 1, 0, postorder.size - 1)

    }


    private fun recursiveBuildTree(
        inorder: IntArray,
        postorder: IntArray,
        inLeft: Int,
        inRight: Int,
        postLeft: Int,
        postRight: Int
    ): TreeNode? {

        if (inLeft > inRight || postLeft > postRight) {

            return null

        }

        val rootTreeNode = TreeNode(postorder[postRight])

        val inLeftLeft = inLeft
        val postLeftLeft = postLeft

        val inPivotIndex = inorderPosMap[postorder[postRight]]

        val inLeftRight = inPivotIndex!! - 1
        val postLeftRight = inLeftRight - inLeftLeft + postLeftLeft

        val inRightLeft = inPivotIndex + 1
        val postRightLeft = postLeftRight + 1

        val inRightRight = inRight
        val postRightRight = postRight - 1

        rootTreeNode.left = recursiveBuildTree(inorder, postorder, inLeftLeft, inLeftRight, postLeftLeft, postLeftRight)
        rootTreeNode.right =
            recursiveBuildTree(inorder, postorder, inRightLeft, inRightRight, postRightLeft, postRightRight)

        return rootTreeNode

    }


}