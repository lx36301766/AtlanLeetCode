package pl.atlantischi.leetcode.easy;

/**
 * Created on 2019/10/20.

     编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母 a-z 。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/longest-common-prefix
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

class Easy14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        char[][] charStrs = new char[strs.length][minLength];
        for (int i=0; i< strs.length; i++) {
            charStrs[i] = strs[i].toCharArray();
        }
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i< minLength; i++) {
            char tmp = '0';
            for (char[] charStr : charStrs) {
                if (tmp == '0') {
                    tmp = charStr[i];
                } else if (tmp != charStr[i]) {
                    return prefix.toString();
                }
            }
            prefix.append(charStrs[0][i]);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {

        //        String[] strs = {"dog","racecar","car"};
        String[] strs = {"flsssower","flsssssow","flssssight"};
        String ret2 = new Easy14().longestCommonPrefix(strs);
        System.out.println(ret2);
    }

}
