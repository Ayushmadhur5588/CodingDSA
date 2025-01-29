import java.util.LinkedList;
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
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(4, 6);
        addEdge(5, 6);

        System.out.println(bfs01(0, vis));
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

}
