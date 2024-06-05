package day59

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/22 PM 11:01:49
 * @version 1.0.0
 * @description 验证二叉搜索树
 * @filename ValidateTheBinarySearchTree.kt
 *
 */

/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左
子树
只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。*/

class Solution {


    private var isValid = true
    private var prevNum = -1
    private var isFirst = true


    fun isValidBST(root: TreeNode?): Boolean {

        if (!isValid) return isValid

        if (root == null) return false

        isValidBST(root.left)

        if (isFirst) {

            isFirst = false

        } else {

            isValid = isValid && (root.`val` > prevNum)

        }
        prevNum = root.`val`

        isValidBST(root.right)

        return isValid

    }


}


fun main() {

    val treeNode1 = TreeNode(5)
    val treeNode2 = TreeNode(1)
    val treeNode3 = TreeNode(4)
    val treeNode4 = TreeNode(3)
    val treeNode5 = TreeNode(6)

    treeNode1.left = treeNode2
    treeNode1.right = treeNode3

    treeNode3.left = treeNode4
    treeNode3.right = treeNode5

    val isValid = Solution().isValidBST(treeNode1)
    println(isValid)


}