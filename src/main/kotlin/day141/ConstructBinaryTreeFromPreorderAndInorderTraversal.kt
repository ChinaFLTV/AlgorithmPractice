package day141

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/2 PM 2:25:13
 * @version 1.0.0
 * @description 从前序与中序遍历序列构造二叉树
 * @filename ConstructBinaryTreeFromPreorderAndInorderTraversal.kt
 *
 */

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。



示例 1:


输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:

输入: preorder = [-1], inorder = [-1]
输出: [-1]


提示:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列*/

class Solution {

    private lateinit var map: Map<Int, Int>


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        map = inorder.withIndex().associate { it.value to it.index }

        return dfs(preorder, inorder, 0, preorder.size - 1, 0, inorder.size - 1)

    }


    private fun dfs(preorder: IntArray, inorder: IntArray, preLeft: Int, preRight: Int, inLeft: Int, inRight: Int): TreeNode? {

        if (preLeft > preRight || inLeft > inRight)
            return null

        val newInorderPivotIdx = map[preorder[preLeft]]

        val leftInorderLeftIdx = inLeft
        val leftInorderRightIdx = newInorderPivotIdx!! - 1
        val leftPreorderLeftIdx = preLeft + 1
        val leftPreorderRightIdx = (leftInorderRightIdx - leftInorderLeftIdx) + leftPreorderLeftIdx

        val rightInorderLeftIdx = newInorderPivotIdx + 1
        val rightInorderRightIdx = inRight
        val rightPreorderLeftIdx = leftPreorderRightIdx + 1
        val rightPreorderRightIdx = preRight

        val rootNode = TreeNode(preorder[preLeft])
        rootNode.left = dfs(preorder, inorder, leftPreorderLeftIdx, leftPreorderRightIdx, leftInorderLeftIdx, leftInorderRightIdx)
        rootNode.right = dfs(preorder, inorder, rightPreorderLeftIdx, rightPreorderRightIdx, rightInorderLeftIdx, rightInorderRightIdx)

        return rootNode

    }


}