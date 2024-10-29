package interview

/**
 *
 * @author Lenovo/LiGuanda
 * @date 2024/10/29 PM 2:25:22
 * @version 1.0.0
 * @description 湍流信息科技-面试-2
 * @filename Interview2.kt
 *
 */

// n个数组，每个数组都是Integer[]类型，其中的元素从小到大排序
// 写一个函数返回一个数组，包含上面n个数组的全部元素，也是从小到大排序

fun mergeArr(arrays: List<Array<Int>>): Array<Int> {

    // [1,2,3,4]  --> [1,2,3,3,4,4,5,6,8] --> m1+m2 -->(l1+l2)  -->(l1+l2+l3+l4)     |  -->(l1+l2)
    // [3,4,5,6,8]                                                                      -->(l1+l2+l3)
    // [1,2,4,5] --> [1,1,2,2,4,5] --> 2(m1+m2)+m3
    // [1,2] --> 2(2(m1+m2)+m3)+m4 = 4m1+4m2+2m3+m4 -->(l3+l4)
    // -->2(m1+m2+m3+m4) = 2m1+2m2+2m3+2m4

}