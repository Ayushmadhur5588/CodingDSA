import java.util.*;

public class algoQuestions {
    // 1192 Articulation point
    class Solution {
        int[] low, disc;
        boolean[] vis;
        int time = 0;

        public void dfs(ArrayList<Integer>[] graph, int src, int par, List<List<Integer>> ans) {
            disc[src] = low[src] = time++;
            vis[src] = true;
            for (Integer v : graph[src]) {
                if (!vis[v]) {
                    dfs(graph, v, src, ans);
                    if (disc[src] < low[v]) {
                        List<Integer> edge = new ArrayList<>(Arrays.asList(src, v));
                        ans.add(edge);
                    }
                    low[src] = Math.min(low[src], low[v]);
                } else if (v != par) {
                    low[src] = Math.min(low[src], disc[v]);
                }

            }
        }
        
    }