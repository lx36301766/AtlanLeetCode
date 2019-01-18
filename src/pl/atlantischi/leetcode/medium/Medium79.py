

class Solution(object):

    # Approach 1: Additional Memory Approach
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        R = len(matrix)
        C = len(matrix[0])
        rows, cols = set(), set()

        # Essentially, we mark the rows and columns that are to be made zero
        for i in range(R):
            for j in range(C):
                if matrix[i][j] == 0:
                    rows.add(i)
                    cols.add(j)

        # Iterate over the array once again and using the rows and cols sets, update the elements
        for i in range(R):
            for j in range(C):
                if i in rows or j in cols:
                    matrix[i][j] = 0

    # Approach 2: Brute O(1) space
    def setZeroes2(self, matrix):

        modify = -999999

        vl = len(matrix)
        hl = len(matrix[0])

        for i in range(vl):
            for j in range(hl):
                if matrix[i][j] == 0:
                    for x in range(hl):
                        if matrix[i][x] != 0:
                            matrix[i][x] = modify
                    for y in range(vl):
                        if matrix[y][j] != 0:
                            matrix[y][j] = modify

        for i in range(vl):
            for j in range(hl):
                if matrix[i][j] == modify:
                    matrix[i][j] = 0

    # Approach 3: O(1) Space, Efficient Solution
    def setZeroes3(self, matrix):
        vl = len(matrix)
        hl = len(matrix[0])

        replaceFirstColum = False
        for i in range(vl):
            if matrix[i][0] == 0:
                replaceFirstColum = True
            for j in range(1, hl):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0

        for i in range(1, vl):
            if matrix[i][0] == 0:
                for j in range(hl):
                     matrix[i][j] = 0
        for j in range(1, hl):
            if matrix[0][j] == 0:
                for i in range(vl):
                     matrix[i][j] = 0

        if matrix[0][0] == 0:
            for j in range(hl):
                matrix[0][j] = 0
        if replaceFirstColum:
            for i in range(vl):
                matrix[i][0] = 0

def main():
    print('this message is from main function')
    solution = Solution()
    matrix = [
        [5, 1, 2, 0],
        [4, 1, 0, 3],
        [0, 5, 2, 3],
        [1, 5, 2, 3],
    ]
    solution.setZeroes3(matrix)
    print(matrix)

if __name__ == '__main__':
    main()
    # print(__name__)