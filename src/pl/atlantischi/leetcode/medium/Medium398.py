"""
    Given an array of integers with possible duplicates, randomly output the index of a given target number.
    You can assume that the given target number must exist in the array.

    Note:
    The array size can be very large. Solution that uses too much extra space will not pass the judge.

    Example:

    int[] nums = new int[] {1,2,3,3,3};
    Solution solution = new Solution(nums);

    // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
    solution.pick(3);

    // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
    solution.pick(1);




    https://www.cnblogs.com/strugglion/p/6424874.html


"""

import random


class Solution:

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        result = -1
        count = 0
        for i, num in enumerate(self.nums):
            if target != num:
                continue
            rnd = random.randint(0, count)
            if rnd == 0:
                result = i
            count += 1
        return result


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)

def main():
    nums = [1, 2, 2, 5, 6, 7, 7, 5, 8, 9]
    obj = Solution(nums)
    result = obj.pick(5)
    print(result)


if __name__ == '__main__':
    main()
