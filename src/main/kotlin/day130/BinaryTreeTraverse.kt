package day130

import day38.TreeNode

/**
 *
 * @author <a href="https://blog.csdn.net/My_Jobs?type=blog">Yaoder</a>
 * @date 2024/10/17 PM 3:43:37
 * @version 1.0.0
 * @description <a href="https://blog.csdn.net/My_Jobs/article/details/43451187">二叉树遍历(前序、中序、后序、层序)</a>
 * @filename BinaryTreeTraverse.kt
 *
 */

fun preOrderTraverse(node: TreeNode) {

    println(node.`val`)
    node.left?.let { preOrderTraverse(it) }
    node.right?.let { preOrderTraverse(it) }

}


fun inOrderTraverse(node: TreeNode) {

    node.left?.let { inOrderTraverse(it) }
    println(node.`val`)
    node.right?.let { inOrderTraverse(it) }

}


fun postOrderTraverse(node: TreeNode) {

    node.left?.let { postOrderTraverse(it) }
    node.right?.let { postOrderTraverse(it) }
    println(node.`val`)

}


fun levelTraverse(node: TreeNode) {

    val queue = ArrayDeque<TreeNode>()
    queue.addLast(node)
    while (queue.isNotEmpty()) {

        val parentNode = queue.removeFirst()
        println(parentNode.`val`)
        parentNode.left?.let { queue.addLast(it) }
        parentNode.right?.let { queue.addLast(it) }

    }

}


fun main() {

    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)

    val node2 = TreeNode(2).apply {

        left = node4
        right = node5

    }
    val node3 = TreeNode(3).apply {

        left = node6
        right = node7

    }
    val node1 = TreeNode(1).apply {

        left = node2
        right = node3

    }

    levelTraverse(node1)

}