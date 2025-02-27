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


        public List<List<Integer>> criticalConnections(int N, List<List<Integer>> connections) {
            ArrayList<Integer>[] graph = new ArrayList[N];
            for (int i = 0; i < N; i++)
                graph[i] = new ArrayList<>();

            for (List<Integer> ar : connections) {
                graph[ar.get(0)].add(ar.get(1));
                graph[ar.get(1)].add(ar.get(0));
            }

            low = new int[N];
            disc = new int[N];

            vis = new boolean[N];
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!vis[i]) {
                    dfs(graph, 0, -1, ans);
                }
            }

            return ans;
        }
    }
    }
}