package day40

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/30 PM 10:18:11
 * @version 1.0.0
 * @description 翻转二叉树
 * @filename FlipTheBinaryTree.kt
 *
 */

/*
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。*/

class Solution {


    private fun invertTree(root: TreeNode?): TreeNode? {

        if (root == null) {

            return null

        }

        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)

        return root

    }


}