package day52

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/5/14 PM 11:14:26
 * @version 1.0.0
 * @description 二叉树的最近公共祖先
 * @filename TheMostRecentCommonAncestorOfBinaryTree.kt
 *
 */

class Solution {


    private val set = mutableSetOf<Int>()
    private lateinit var parent: TreeNode


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        if (root == null) return null

        set.clear()
        set.add(root.`val`)
        root.left?.run {

            set.add(`val`)

        }
        root.right?.run {

            set.add(`val`)

        }

        if (set.contains(p!!.`val`) && set.contains(q!!.`val`)) return root

        if (set.contains(p.`val`) || set.contains(q!!.`val`)) {

            if (root.`val` == p.`val`) {

                return if (find(root.left, q!!.`val`) || find(root.right, q.`val`)) root else parent

            }
            if (root.`val` == q!!.`val`) {

                return if (find(root.left, p.`val`) || find(root.right, p.`val`)) root else parent

            }
            if (root.left != null && (root.left as TreeNode).`val` == p.`val`) {

                return if (find(root.left, q.`val`)) root.left!! else root

            }
            if (root.left != null && (root.left as TreeNode).`val` == q.`val`) {

                return if (find(root.left, p.`val`)) root.left!! else root

            }
            if (root.right != null && (root.right as TreeNode).`val` == p.`val`) {

                return if (find(root.right, q.`val`)) root.right!! else root

            }
            if (root.right != null && (root.right as TreeNode).`val` == q.`val`) {

                return if (find(root.right, p.`val`)) root.right!! else root

            }

        }

        parent = root
        val maybe1 = lowestCommonAncestor(root.left, p, q)
        val maybe2 = lowestCommonAncestor(root.right, p, q)

        return maybe1 ?: maybe2

    }


    private fun find(root: TreeNode?, target: Int): Boolean {

        if (root == null) return false
        if (root.`val` == target) return true
        return find(root.left, target) || find(root.right, target)

    }


}