package interview

import day38.TreeNode

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/11/13 PM 6:25:28
 * @version 1.0.0
 * @description 瓴岳科技-面试-1
 * @filename Lingyuekeji_1.kt
 *
 */

var res: Int? = null

fun findNextNode(root: TreeNode?, target: Int): Int? {

    inorderTraversal(root, target)

    return res

}


private fun inorderTraversal(root: TreeNode?, target: Int): Boolean {

    if (root == null)
        return false

    val isTargetLeft = inorderTraversal(root.left, target)

    if (isTargetLeft) {

        res = root.`val`
        return false

    }

    if (root.`val` == target) {

        return true

    } else {

        return inorderTraversal(root.right, target)

    }

}