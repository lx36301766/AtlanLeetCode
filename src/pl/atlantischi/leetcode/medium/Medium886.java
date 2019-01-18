package pl.atlantischi.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Medium886 {

    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap<>();
        for (int node = 1; node <= N; ++node) {
            if (!color.containsKey(node) && !dfs(node, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int c) {
        if (color.containsKey(node)) {
            return color.get(node) == c;
        }
        color.put(node, c);
        for (int nei : graph[node]) {
            if (!dfs(nei, ~c)) {
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {
        Medium886 solution = new Medium886();
        int[][] dislikes = {
            {1, 2},
            {4, 1},
            {2, 5},
            {3, 5}
        };
        boolean a = solution.possibleBipartition(6, dislikes);
        System.out.println(a);
    }
}