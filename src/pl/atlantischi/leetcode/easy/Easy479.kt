package pl.atlantischi.leetcode.easy

/**

    你需要找到由两个 n 位数的乘积组成的最大回文数。

    由于结果会很大，你只需返回最大回文数 mod 1337 得到的结果。

    示例:

    输入: 2

    输出: 987

    解释: 99 x 91 = 9009, 9009 % 1337 = 987

    说明:

    n 的取值范围为 [1,8]。

 */


fun largestPalindrome(n: Int): Int {
    if (n == 1) {
        return 9
    }
    val ret = longArrayOf(9, 9009, 906609, 99000099, 9966006699, 999000000999, 99956644665999, 9999000000009999)
    return (ret[n - 1] % 1337).toInt()
}

fun largestPalindrome2(n: Int): Int {
    if (n == 1) {
        return 9
    }
    val upper = Math.pow(10.0, n.toDouble()).toInt() - 1
    val lower = upper / 10

    val max = upper * upper
    var firstHalf = upper - 1
    var palindrome: Long = 0

    var palindromeFound = false
    while (!palindromeFound) {

        palindrome = createPalindrome(firstHalf)

        for (i in upper downTo lower) {
            if (i * i < palindrome || palindrome / i > max) {
                break
            }
            if ((palindrome % i).toInt() == 0) {
                palindromeFound = true
                break
            }
        }
        firstHalf--
    }

    return (palindrome % 1337).toInt()
}

private fun createPalindrome(num: Int): Long = (num.toString() + num.toString().reversed()).toLong()


fun main(args: Array<String>) {

    println(largestPalindrome2(1))
    println(largestPalindrome2(2))
    println(largestPalindrome2(3))
    println(largestPalindrome2(4))
    println(largestPalindrome2(5))
    println(largestPalindrome2(6))
    println(largestPalindrome2(7))
    println(largestPalindrome2(8))

}
