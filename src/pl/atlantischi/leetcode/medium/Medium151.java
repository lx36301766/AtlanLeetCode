package pl.atlantischi.leetcode.medium;

/**

    给定一个字符串，逐个翻转字符串中的每个单词。

    示例:

    输入: "the sky is blue",
    输出: "blue is sky the".

    说明:

    无空格字符构成一个单词。
    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
    进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。


 */

class Medium151 {

    public String reverseWords(String str) {
        char[] strArr = str.trim().toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean appendSpace = false;
        int offset = 0;
        for (int i = strArr.length - 1; i >= 0; i--) {
            char c = strArr[i];
            if (c == ' ') {
                if (appendSpace) builder.append(' ');
                appendSpace = false;
                offset = builder.length();
            } else {
                builder.insert(offset, c);
                appendSpace = true;
            }
        }
        return builder.toString();
    }




    public String reverseWords2(String str) {
        char[] strArr = str.toCharArray();
        int length = strArr.length;
        reverse(strArr, 0, length - 1);
        reverseWords(strArr, length);
        return cleanSpaces(strArr, length);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ')
                i++; // skip spaces
            while (j < i || j < n && a[j] != ' ')
                j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }
        return new String(a).substring(0, i);
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Medium151().reverseWords2("  the   sky  is     blue "));
    }

}
