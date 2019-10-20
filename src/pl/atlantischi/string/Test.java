package pl.atlantischi.string;

/**
 * Created on 2019/10/20.

     给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

     示例 1:

     输入: "Let's take LeetCode contest"
     输出: "s'teL ekat edoCteeL tsetnoc"
     注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

 */

class Test {

    public String reverseWords(String s) {
        char tmp = '0';
        char[] sArr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < sArr.length; i++) {
            char arr = sArr[i];
            if (arr == ' ' || i == sArr.length - 1) {
                int end = i - 1;
                if (i == sArr.length - 1) end += 1;
                reverseString(sArr, start, end);
                start = i + 1;
            }
        }
        char[][] charStrs = new char[5][5];
        return new String(sArr);
    }

    public void reverseString(char[] s, int start, int end) {
        int length = end - start + 1;
        for (int i = start; i < start + length / 2; i++) {
            int offset = i - start;
            int sIndex = start + offset;
            int eIndex = end - offset;
            int sum = s[sIndex] + s[eIndex];
            s[sIndex] = s[eIndex];
            s[eIndex] = (char) (sum - s[sIndex]);
        }
    }

    public static void main(String[] args) {
        String ret = new Test().reverseWords("Let's take LeetCode contest");
        System.out.println(ret);

    }

}

