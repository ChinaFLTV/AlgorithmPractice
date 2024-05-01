package day41

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/1 PM 10:48:15
 * @version 1.0.0
 * @description 对称二叉树
 * @filename SymmetricBinaryTree.kt
 *
 */

/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。*/

class Solution {


    fun isSymmetric(root: TreeNode?): Boolean {

        return subIsSymmetric(root!!.left, root.right)

    }


    private fun subIsSymmetric(left: TreeNode?, right: TreeNode?): Boolean {

        if (left == null && right == null) {

            return true

        }

        if (left == null || right == null) {

            return false

        }

        if (left.`val` != right.`val`) {

            return false

        }

        return subIsSymmetric(left.left, right.right) && subIsSymmetric(left.right, right.left)

    }


}