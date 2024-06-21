package day87

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/21 PM 6:18:05
 * @version 1.0.0
 * @description 快乐数
 * @filename HappyNumber.kt
 *
 */

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。*/

class Solution {


    /**
     *
     * @author <a href="https://leetcode.cn/u/linux-man/">金字塔下的小蜗牛</a>
     * @date 2024/6/21 PM 7:14:02
     * @version 1.0.0
     * @description <a href="https://leetcode.cn/problems/happy-number/solutions/21454/shi-yong-kuai-man-zhi-zhen-si-xiang-zhao-chu-xun-h/?envType=study-plan-v2&envId=top-interview-150">使用“快慢指针”思想找出循环，不要使用集合或递归！！</a>
     * @filename HappyNumber.kt
     *
     */
    fun isHappy_answer_1(n: Int): Boolean {

        var slow = n
        var fast = n

        do {

            slow = calculateSquareSum(slow)
            fast = calculateSquareSum(calculateSquareSum(fast))

        } while (slow != fast)

        return fast == 1

    }


    private fun calculateSquareSum(n: Int): Int {

        var squareSum = 0
        var curN = n
        while (curN != 0) {

            squareSum += ((curN % 10) * (curN % 10))
            curN /= 10

        }

        return squareSum

    }


}