package pl.atlantischi.leetcode.easy

/**

    Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
    then the whole array will be sorted in ascending order, too.

    You need to find the shortest such subarray and output its length.

    Example 1:
    Input: [2, 6, 4, 8, 10, 9, 15]
    Output: 5
    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
    Note:
    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.


    给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

    你找到的子数组应是最短的，请输出它的长度。

    示例 1:

    输入: [2, 6, 4, 8, 10, 9, 15]
    输出: 5
    解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    说明 :

    输入的数组长度范围在 [1, 10,000]。
    输入的数组可能包含重复元素 ，所以升序的意思是<=。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//Time complexity : O(n)O(n). Four O(n)O(n) loops are used.
//Space complexity : O(1)O(1). Constant space is used.

//这个算法背后的思想是无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
//
//因此，首先我们需要找到原数组在哪个位置开始不是升序的。我们从头开始遍历数组，一旦遇到降序的元素，我们记录最小元素为 minmin 。
//
//类似的，我们逆序扫描数组 numsnums，当数组出现升序的时候，我们记录最大元素为 maxmax。
//
//然后，我们再次遍历 numsnums 数组并通过与其他元素进行比较，来找到 minmin 和 maxmax 在原数组中的正确位置。我们只需要从头开始找到第一个大于 minmin 的元素，从尾开始找到第一个小于 maxmax 的元素，它们之间就是最短无序子数组。
//
//我们可以再次使用下图作为说明：
//
//
//
//我们观察到指针 bb 在下标 0 以后，标记着无序子数组的左边界，指针 aa 在下标 7 以前，标记着无序子数组的右边界

fun findUnsortedSubarray(nums: IntArray): Int {
    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    var flag = false
    for (i in 1 until nums.size) {
        if (nums[i] < nums[i - 1])
            flag = true
        if (flag)
            min = Math.min(min, nums[i])
    }
    flag = false
    for (i in nums.size - 2 downTo 0) {
        if (nums[i] > nums[i + 1])
            flag = true
        if (flag)
            max = Math.max(max, nums[i])
    }
    var l = 0
    var r = nums.size - 1
    while (l < nums.size) {
        if (min < nums[l])
            break
        l++
    }
    while (r >= 0) {
        if (max > nums[r])
            break
        r--
    }
    return if (r - l < 0) 0 else r - l + 1
}


// sort
//Time complexity : O(nlogn)O(nlogn). Sorting takes nlognnlogn time.
//Space complexity : O(n)O(n). We are making copy of original array.

fun findUnsortedSubarray2(nums: IntArray): Int {
    var l = nums.size
    var r = 0
    for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[j] < nums[i]) {
                r = Math.max(r, j)
                l = Math.min(l, i)
            }
        }
    }
    return if (r - l < 0) 0 else r - l + 1
}

fun main(args: Array<String>) {

    println(findUnsortedSubarray2(intArrayOf(1)))
    println(findUnsortedSubarray2(intArrayOf(2, 1)))
    println(findUnsortedSubarray2(intArrayOf(1, 2, 3, 4)))
    println(findUnsortedSubarray2(intArrayOf(1, 3, 5, 4, 2)))
    println(findUnsortedSubarray2(intArrayOf(12, 21, 9, 11, 15)))
    println(findUnsortedSubarray2(intArrayOf(8, 6, 5, 7, 9)))
    println(findUnsortedSubarray2(intArrayOf(3, 2, 1)))
    println(findUnsortedSubarray2(intArrayOf(2, 6, 4, 8, 10, 9, 15)))
    println(findUnsortedSubarray2(intArrayOf(2, 3, 3, 5, 5, 6, 4, 8, 10, 9, 9, 10, 12, 15)))

}
