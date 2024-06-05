package day71

import kotlin.random.Random

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/6/4 PM 8:31:29
 * @version 1.0.0
 * @description O(1) 时间插入、删除和获取随机元素
 * @filename InsertDeleteAndGetRandomElementsInO1Time.kt
 *
 */

/*实现RandomizedSet 类：

RandomizedSet() 初始化 RandomizedSet 对象
bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。*/

class RandomizedSet {


    private val map = HashMap<Int, Int>()
    private val list = ArrayList<Int>()
    private val random = Random(666)


    fun insert(`val`: Int): Boolean {

        if (map.containsKey(`val`))
            return false

        map[`val`] = list.size

        list.add(`val`)

        return true

    }


    fun remove(`val`: Int): Boolean {

        if (!map.containsKey(`val`))
            return false

        val index = map.get(`val`) as Int

        list[index] = list[list.size - 1]
        map[list[list.size - 1]] = index
        list.removeLast()
        map.remove(`val`)

        return true

    }


    fun getRandom(): Int {

        return list[random.nextInt(list.size)]

    }


}


fun main() {

    val set = RandomizedSet()
    /*set.insert(0)
    set.insert(1)
    set.remove(0)
    set.insert(2)
    set.remove(1)
    val random = set.getRandom()
    println(random)*/

    set.remove(0)
    set.remove(0)
    set.insert(0)
    val random = set.getRandom()
    set.remove(0)
    set.insert(0)

    /*set.insert(1)
    set.insert(10)
    set.insert(20)
    set.insert(30)
    var random = set.getRandom()
    println(random)
    random = set.getRandom()
    println(random)*/

}