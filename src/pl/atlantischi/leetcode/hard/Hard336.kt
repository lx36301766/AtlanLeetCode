package pl.atlantischi.leetcode.hard

/**

	给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。

	示例 1:

	输入: ["abcd","dcba","lls","s","sssll"]
	输出: [[0,1],[1,0],[3,2],[2,4]]
	解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
	示例 2:

	输入: ["bat","tab","cat"]
	输出: [[0,1],[1,0]]
	解释: 可拼接成的回文串为 ["battab","tabbat"]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-pairs
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

class Solution {
	fun ispali(x: String?): Boolean {
		if (x == null)
			return false
		for (i in 0 until x.length / 2)
			if (x[i] != x[x.length - 1 - i])
				return false
		return true
	}

	fun palindromePairs(words: Array<String>): List<List<Int>> {
		val re = arrayListOf<ArrayList<Int>>()

		val self = BooleanArray(words.size)
		for (i in words.indices)
			self[i] = ispali(words[i])
		for (i in 0 until words.size - 1) {
			for (j in i + 1 until words.size) {
				if (self[i] && self[j]) {
					if (ispali(words[i] + words[j])) {
						var tt: ArrayList<Int> = ArrayList()
						tt.add(i)
						tt.add(j)
						re.add(tt)
						tt = ArrayList()
						tt.add(j)
						tt.add(i)
						re.add(tt)
					}
				} else {
					if (ispali(words[i] + words[j])) {
						val tt = ArrayList<Int>()
						tt.add(i)
						tt.add(j)
						re.add(tt)
					} else {
						if (ispali(words[j] + words[i])) {
							val tt = ArrayList<Int>()
							tt.add(j)
							tt.add(i)
							re.add(tt)
						}
					}
				}
			}
		}
		return re
	}
}