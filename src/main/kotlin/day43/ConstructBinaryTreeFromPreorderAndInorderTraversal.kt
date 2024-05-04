package day43

import day38.TreeNode
import day42.Solution

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/4 PM 11:04:39
 * @version 1.0.0
 * @description
 * @filename ConstructBinaryTreeFromPreorderAndInorderTraversal.kt
 *
 */

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。*/

class Solution {


    private lateinit var map: Map<Int, Int>
    private lateinit var preorder: IntArray
    private lateinit var inorder: IntArray


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        this.map = inorder.withIndex().associate { e -> e.value to e.index }
        this.preorder = preorder
        this.inorder = inorder

        return recursiveBuildTree(0, preorder.size - 1, 0, inorder.size - 1)

    }


    private fun recursiveBuildTree(
        preLeft: Int,
        preRight: Int,
        inLeft: Int,
        inRight: Int
    ): TreeNode? {

        if (preLeft > preRight || inLeft > inRight) {

            return null

        }

        val pivotInIndex = map[preorder[preLeft]]
        val inLeftLeft = inLeft
        val inLeftRight = pivotInIndex!! - 1
        val inRightLeft = pivotInIndex + 1
        val inRightRight = inRight
        val preLeftLeft = preLeft + 1
        val preLeftRight = inLeftRight - inLeftLeft + preLeftLeft
        val preRightLeft = preLeftRight + 1
        val preRightRight = preRight

        val curRootTreeNode = TreeNode(preorder[preLeft])

        curRootTreeNode.left = recursiveBuildTree(preLeftLeft, preLeftRight, inLeftLeft, inLeftRight)
        curRootTreeNode.right = recursiveBuildTree(preRightLeft, preRightRight, inRightLeft, inRightRight)

        return curRootTreeNode

    }


}


fun main() {

    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    Solution().buildTree(preorder, inorder)

}