package pl.atlantischi.base

/**
 * Created on 16/10/2018.

 * @author lx
 */


class ListNode @JvmOverloads constructor (var value: Int = 0, nextBlock: (ListNode.() -> ListNode?)? = null) {

    @JvmField
    var next: ListNode? = nextBlock?.invoke(this)

    override fun toString(): String {
        return "ListNode(value=$value, next=$next)"
    }

}

fun ListNode.printNode() {
    var tmpNode : ListNode? = this
    while (tmpNode != null) {
        print(tmpNode.value)
        if (tmpNode.next != null) {
            print("-")
        }
        tmpNode = tmpNode.next
    }
    println()
}
