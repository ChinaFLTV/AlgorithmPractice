package day53

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/16 PM 11:29:11
 * @version 1.0.0
 * @description 二叉树的最近公共祖先
 * @filename TheMostRecentCommonAncestorOfBinaryTree.kt
 *
 */

/*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”*/

class Solution {


    private var isFoundParent = false
    private lateinit var parent: TreeNode


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        if (root == null) return null
        if (root.left == null && root.right == null) {

            return if (root.`val` == p!!.`val` || root.`val` == q!!.`val`) root else null

        }

        val leftParent = lowestCommonAncestor(root.left, p, q)
        val rightParent = lowestCommonAncestor(root.right, p, q)

        if (isFoundParent) return parent

        if (leftParent == null && rightParent == null) {

            return if (root.`val` == p!!.`val` || root.`val` == q!!.`val`) root else null

        }
        if (leftParent == null || rightParent == null) {

            if (root.`val` == p!!.`val` || root.`val` == q!!.`val`) {

                isFoundParent = true
                parent = root
                return root

            } else {

                return root

            }

        }

        isFoundParent = true
        parent = root
        return root

    }


}