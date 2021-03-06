package pl.atlantischi.leetcode.easy

import pl.atlantischi.base.TreeNode
import pl.atlantischi.base.printTree


/**

    Given two binary trees and imagine that when you put one of them to cover the other,
    some nodes of the two trees are overlapped while the others are not.

    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
    then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

    Example 1:

    Input:
    Tree 1            Tree 2
        1                2
       / \              / \
      3   2            1   3
     /                  \   \
    5                    4   7
    Output:
    Merged tree:
        3
       / \
      4   5
     / \   \
    5   4   7


    Note: The merging process must start from the root nodes of both trees.


    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

    你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

    注意: 合并必须从两个树的根节点开始。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-two-binary-trees
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) return t2
    if (t2 == null) return t1

    val root = TreeNode(t1.value + t2.value)
    root.left = mergeTrees(t1.left, t2.left)
    root.right = mergeTrees(t1.right, t2.right)

    return root
}

//fun mergeTrees2(t1: TreeNode?, t2: TreeNode?): TreeNode {
//    if (t1 == null) return t2
//    val stack = Stack<Array<TreeNode>>()
//    stack.push(arrayOf(t1, t2))
//    while (!stack.isEmpty()) {
//        val t = stack.pop()
//        if (t[0] == null || t[1] == null) {
//            continue
//        }
//        t[0].value += t[1].value
//        if (t[0].left == null) {
//            t[0].left = t[1].left
//        } else {
//            stack.push(arrayOf<TreeNode>(t[0].left, t[1].left))
//        }
//        if (t[0].right == null) {
//            t[0].right = t[1].right
//        } else {
//            stack.push(arrayOf<TreeNode>(t[0].right, t[1].right))
//        }
//    }
//    return t1
//}

fun main(args: Array<String>) {


    var t3 =
        TreeNode(1) {
            left = TreeNode(3) {
                left = TreeNode(5)
            }
            right = TreeNode(2) {
            }
        }
    var t4 =
        TreeNode(2) {
            left = TreeNode(1) {
                right = TreeNode(4)
            }
            right = TreeNode(3) {
                right = TreeNode(7)
            }
        }

    t3.printTree()
    t4.printTree()
    mergeTrees(t3, t4)?.printTree()

    var t1 =
        TreeNode(1) {
            left = TreeNode(2) {
                left = TreeNode(4) {
                    left = TreeNode(8)
                    right = TreeNode(9)
                }
                right = TreeNode(5) {
                    left = TreeNode(10)
                    right = TreeNode(11)
                }
            }
            right = TreeNode(3) {
                left = TreeNode(6) {
                    left = TreeNode(12)
                    right = TreeNode(13)
                }
                right = TreeNode(7) {
                    left = TreeNode(14)
                    right = TreeNode(15)
                }
            }
        }
    var t2 =
        TreeNode(1) {
            left = TreeNode(2) {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3) {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }

    t1.printTree()
    t2.printTree()
    mergeTrees(t1, t2)?.printTree()

}