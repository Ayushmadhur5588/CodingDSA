import java.util.*;
import java.util.ArrayList;

public class bfs {

    public static int N = 7;
    
    public static ArrayList<Integer>[] graph = new ArrayList[7];
    
    public static void addEdge(int u, int v){
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void main(String[] args){
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        boolean[] vis = new boolean[N];
        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(1, 2);
      //  addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(4, 6);
     //   addEdge(5, 6);

       // System.out.println(bfs01(0, vis));
        System.out.println(isTree(0, graph));
    }
   
    public static int bfs01(int src, boolean[] vis){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        int countOfCycle = 0;
        while(queue.size() != 0){
            int size = queue.size();
            while(size-- > 0){
                int rVtx = queue.removeFirst();
                if(vis[rVtx]){
                    countOfCycle++;
                    continue;
                }
                vis[rVtx] = true;
                for(Integer e : graph[rVtx]){
                    if(!vis[e]){
                        queue.addLast(e);
                    }
                }

            }
       
        }
        return countOfCycle;

    }
    
    public static void bfs02(int src, boolean[] vis){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        vis[src] = true;
        while(queue.size() != 0){
            int size = queue.size();
            while(size-- > 0){
                int rVtx = queue.removeFirst();
                
                for(Integer e : graph[rVtx]){
                    if(!vis[e]){
                        queue.addLast(e);
                        vis[e] = true;
                    }
                }
            }
        }
    }

    public static boolean isTree(int src, ArrayList<Integer>[] graph){
        boolean res = true;
        //call bfs get count of cycle
        int connectedComponents = 0;
        boolean[] vis = new boolean[graph.length];
        int cycle = 0;
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
             connectedComponents++;
             cycle = cycle + bfs01(i, vis);
            }
        }
        if(connectedComponents != 1 || cycle > 0){
           res = false;
        }
        return res;
    }

    public static boolean isBipartite(int src){
        LinkedList<Integer> que = new LinkedList<>();
        int[] vis = new int[N];
        Arrays.fill(vis,-1);

        que.addLast(src);
        int color = 0;

        // -1 -> undefine, 0 -> red, 1 -> green.
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rvtx = que.removeFirst();
                if(vis[rvtx] != -1){
                    if(vis[rvtx] != color)  // conflict
                      return false;
                    
                    continue;
                }

                vis[rvtx] = color;
                for(int e : graph[rvtx]){
                    if(vis[e.v] == -1){
                        que.addLast(e.v);
                    }
                }
            }

            color = (color + 1) % 2;
        }

        return true;
    }


    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        int m = grid.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int firstCell = grid[0][0], lastCell = grid[m-1][m-1];
        int count = 0;
        if(firstCell == 1 || lastCell == 1)return -1;
        queue.addLast(firstCell);
        
        while(queue.size() != 0){
            int size = queue.size();
         
            while(size-- > 0){
                int removeCell = queue.removeFirst();
                int sr = removeCell / m , sc = removeCell % m;

                if(sr == m - 1 && sc == m - 1){
                  count++;
                  break;
                }

                for(int d = 0; d < 8; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if(r >= 0 && c >= 0 && r < m && c < m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        queue.addLast(r * m + c);
                    }
                }

            }
            count++;
        }

        return count;
    }


    public void wallsAndGates(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return;

        int n = grid.length, m = grid[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    que.addLast(i * m + j);
                }
            }
        }

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;

                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 2147483647) {
                        grid[r][c] = grid[sr][sc] + 1;
                        que.addLast(r * m + c);
                    }
                }
            }
        }
    }

}
