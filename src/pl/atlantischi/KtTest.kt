package pl.atlantischi

import pl.atlantischi.base.ListNode
import pl.atlantischi.base.printNode
import pl.atlantischi.leetcode.medium.Medium61

/**
 * Created on 2019/10/21.

 * @author lx
 */


fun main(args: Array<String>) {

    var s = ListNode(5) {
        ListNode(1) {
            ListNode(3) {
                ListNode(2) {
                    ListNode(4)
                }
            }
        }
    }

    var s2 = ListNode(1)

    var listNode = Medium61().rotateRight(s2, 0)
    listNode.printNode()
}