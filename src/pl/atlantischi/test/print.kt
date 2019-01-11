package pl.atlantischi.test

/**
 * Created on 2018/12/29.

 * @author lx
 */


fun main(args: Array<String>) {
    printMatrix2(5)
}

fun printMatrix2(n: Int) {
    val max = n
    for (i in 1 until max ) {
        for (j in 1 until max) {
            val num = Math.min(i, j)
            print(num)
        }
        println()
    }
}


fun printMatrix(n: Int) {
    val max = (n + 1) * 2 - 1
    for (i in 1 until max ) {
        val ii = if (i > n) max - i else i
        for (j in 1 until max) {
            val jj = if (j > n) max - j else j
            val num = Math.min(ii, jj)
            print(num)
        }
        println()
    }
}
