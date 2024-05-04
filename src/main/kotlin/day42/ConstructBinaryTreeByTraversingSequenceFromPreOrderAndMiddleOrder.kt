package day42

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/2 PM 10:40:10
 * @version 1.0.0
 * @description 从前序和中序遍历序列构造二叉树
 * @filename ConstructBinaryTreeByTraversingSequenceFromPreOrderAndMiddleOrder.kt
 *
 */

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。*/

class Solution {


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        if (preorder.size == 1) {

            return TreeNode(preorder[0])

        }

        // 加快遍历速度
        val preorderMap = preorder.withIndex().associate { it.value to it.index }
        val inorderMap = inorder.withIndex().associate { it.value to it.index }

        return recursiveBuildTree(TreeNode(preorder[0]), preorder, inorder, preorderMap, inorderMap, -3001)

    }


    private fun recursiveBuildTree(
        curNode: TreeNode?,
        preorder: IntArray,
        inorder: IntArray,
        preorderMap: Map<Int, Int>,
        inorderMap: Map<Int, Int>,
        parentNodeVal: Int
    ): TreeNode? {

        if (curNode == null) {

            return null

        }

        // 2024-5-3  23:35-判断有无左子树的依据：通过中序遍历去确认当前节点(curNode.left)的中序遍历数组左侧是否是curNode，
        // 若不是，则紧挨着的就是其左子树，否则则无左子树(也就是说，递归需要用到其直接父节点的值)
        /*curNode.left = if (inorderMap[curNode.`val`]-1) TreeNode(preorder[preorderMap[curNode.`val`]!! + 1]) else null
        curNode.right =
            if ((2 * order + 1) <= preorder.size) TreeNode(inorder[preorderMap[inorder[inorderMap[curNode.`val`]!! - 1]]!! + 1]) else null*/

        recursiveBuildTree(curNode.left, preorder, inorder, preorderMap, inorderMap, curNode.`val`)
        recursiveBuildTree(curNode.right, preorder, inorder, preorderMap, inorderMap, curNode.`val`)

        return curNode

    }


}

fun main() {

    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    Solution().buildTree(preorder, inorder)

}