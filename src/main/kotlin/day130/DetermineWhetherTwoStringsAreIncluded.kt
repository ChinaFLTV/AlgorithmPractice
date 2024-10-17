package day130

/**
 *
 * @author <a href="https://blog.csdn.net/qq_25554527?type=blog">西八没天台</a>
 * @date 2024/10/17 PM 4:45:54
 * @version 1.0.0
 * @description <a href="https://blog.csdn.net/qq_25554527/article/details/78090830">判断两个字符串是否为包含关系</a>
 * @filename DetermineWhetherTwoStringsAreIncluded.kt
 *
 */

fun determineWhetherTwoStringsAreIncluded(string: String, subString: String): Boolean {

    val map = mutableMapOf(
        'a' to 2, 'b' to 3, 'c' to 5, 'd' to 7, 'e' to 11, 'f' to 13, 'g' to 17,
        'h' to 19, 'i' to 23, 'j' to 29, 'k' to 31, 'l' to 37, 'm' to 41, 'n' to 43,
        'o' to 47, 'p' to 53, 'q' to 59,
        'r' to 61, 's' to 67, 't' to 71,
        'u' to 73, 'v' to 79, 'w' to 83, 'x' to 89, 'y' to 97, 'z' to 101
    )

    var product = 1

    for (i in string.lowercase().toCharArray())
        product *= map[i] ?: 1

    var subProduct = 1

    for (i in subString.lowercase().toCharArray())
        subProduct *= map[i] ?: 1

    return product % subProduct == 0

}

fun main() {

    val str = "abcdefg"
    val subStr = "def"

    println(determineWhetherTwoStringsAreIncluded(str, subStr))

}