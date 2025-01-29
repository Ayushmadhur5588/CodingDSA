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


}
