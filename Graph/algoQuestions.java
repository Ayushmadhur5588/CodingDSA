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
    
        // 743
    public int networkDelayTime(int[][] times, int n, int k) {
        // {v,w}
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new int[] { v, w });
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        // {vtx,wsf}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[] { k, 0 });
        dist[k] = 0;

        while (pq.size() != 0) {
            int[] rp = pq.remove(); // remove pair
            int vtx = rp[0], wsf = rp[1];

            if (wsf > dist[vtx])
                continue;

            for (int[] e : graph[vtx]) {
                int v = e[0], w = e[1];
                if (wsf + w < dist[v]) {
                    dist[v] = wsf + w;
                    pq.add(new int[] { v, wsf + w });
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }


    }
}