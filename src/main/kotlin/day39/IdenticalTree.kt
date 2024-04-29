package day39

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/4/29 PM 10:17:43
 * @version 1.0.0
 * @description 相同的树
 * @filename IdenticalTree.kt
 *
 */

/*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/

class Solution {


    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

        if ((p == null && q != null) || (p != null && q == null)) {

            return false

        }

        if (p == null && q == null) {

            return true

        }

        return if (p?.`val` == q?.`val`) {

            isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)

        } else {

            false

        }

    }


}