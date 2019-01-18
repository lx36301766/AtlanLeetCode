import collections


class Solution(object):

    def possibleBipartition(self, N, dislikes):

        graph = collections.defaultdict(list)
        for u, v in dislikes:
            graph[u].append(v)
            graph[v].append(u)

        color = {}

        def dfs(node, c=0):
            if node in color:
                return color[node] == c
            color[node] = c
            return all(dfs(nei, c ^ 1) for nei in graph[node])

        return all(dfs(node)
                   for node in range(1, N + 1)
                   if node not in color)


def main():
    solution = Solution()
    dislike = [
        [1, 2],
        [4, 1],
        [2, 5],
        [3, 5],
    ]
    ret = solution.possibleBipartition(6, dislike)
    print(ret)


if __name__ == '__main__':
    main()
    # print(__name__)
