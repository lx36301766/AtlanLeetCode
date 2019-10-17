package pl.atlantischi.leetcode.easy

/**

    给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。

    (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

    注意：

    你可以假设两个字符串均只含有小写字母。

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/ransom-note
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val magazineLetterCount = IntArray(26)
    for (char in magazine) {
        magazineLetterCount[char - 'a']++
    }
    for (char in ransomNote) {
        if (--magazineLetterCount[char - 'a'] < 0) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    println(canConstruct("cabaabbc", "aaabbbccc"))
    println(canConstruct("cababbc", "aaabbbc"))
}
