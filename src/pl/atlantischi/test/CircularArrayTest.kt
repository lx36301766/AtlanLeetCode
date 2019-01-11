package pl.atlantischi.test

import pl.atlantischi.other.CircularArray

/**
 * Created on 2019/1/8.

 * @author lx
 */


fun main(args: Array<String>) {

    val array = CircularArray<String>(22)
    array.addFirst("a")
    array.addFirst("b")
    array.addFirst("c")
    array.addFirst("d")
    array.addFirst("e")
    array.addFirst("f")
    array.addFirst("g")
    array.addFirst("h")

    array.addFirst("i")
    array.addFirst("j")
    array.addFirst("k")
    array.addLast("1")
    array.addLast("2")
    array.addLast("3")
    array.addLast("4")
    array.addLast("5")
//    array.addLast("6")


    println()

}
