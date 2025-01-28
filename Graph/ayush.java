import java.util.ArrayList;

public class ayush {

   public static class Edge{
        int v = 0;
        int w = 0;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
   } 

   @SuppressWarnings("unchecked")
   static int N = 7;
   public static ArrayList<Edge>[] graph = new ArrayList[N];
   
   public static void main(String[] args){
    for(int i = 0; i < N; i++){
        graph[i] = new ArrayList<>();
    }
    boolean[] vis = new boolean[N];
        addEdge(0, 1, 10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
    
        //display();
        //System.out.println(findEdge(0, 1));
        //removeEdge(2, 3);
        //display();
       //removeVtx(3);
       // System.out.println(hasPath(0, 6, vis));
        allPath(0, 6, vis, new StringBuilder());
        
    }
   
   
   public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
   }
   
   public static void display(){
    for(int i = 0; i < N; i++){
        System.out.print(i + " ->" + " ");
        for(int j = 0; j < graph[i].size(); j++){
            Edge e = graph[i].get(j);
            System.out.print("(" + e.v + ")");
        }
        System.out.println();
    }
   }

   public static int findEdge(int u, int v){
    int res = -1;
    ArrayList<Edge> list = graph[u];
    for(int i = 0; i < list.size(); i++){
        Edge e = list.get(i);
        if(e.v == v){
            res = i;
            break;
        }
   }
   return res;
   }

   public static void removeEdge(int u, int v){
    int idx1 = findEdge(u, v);
    int idx2  = findEdge(v, u);

    if(idx1 != - 1){
        graph[u].remove(idx1);
    }

    if(idx2 != - 1){
        graph[v].remove(idx2);
    }
   }

   public static void removeVtx(int u){
        ArrayList<Edge> list = graph[u];
        for(int i = list.size() - 1; i >= 0; i--){
            Edge e = list.get(i);
            removeEdge(u, e.v);
        }
   }

   public static boolean hasPath(int src, int des, boolean[]vis){
    if(src == des)return true;

    vis[src] = true;
    for(Edge e : graph[src]){
        if(!vis[e.v]){
          boolean res = hasPath(e.v, des, vis);
          if(res)return res;
        }
    }
    return false;
   }

   public static void allPath(int src, int des, boolean[]vis, StringBuilder ans){
    if(src == des){
        System.out.println(ans.toString() + src);
        return;
    }

    vis[src] = true;
    ans.append(src); // 012345
    for(Edge e : graph[src]){ //13 02 13 024 356 
        if(!vis[e.v]){ //
         allPath(e.v, des, vis, ans);//1 | 2 | 3 | 4 | 5,6
        }
    }
    ans.deleteCharAt(ans.length() - 1); //5
    vis[src] = false;
    return;
   }
   
   public static void dfs(int src, boolean[] vis) {
    vis[src] = true;
    for (Edge e : graph[src])
        if (!vis[e.v])
            dfs(e.v, vis);
}

   public static void gcc() {
    boolean[] vis = new boolean[N];
    int components = 0;
    for (int i = 0; i < N; i++) {
        if (!vis[i]) {
            components++;
            dfs(i, vis);
        }
    }
}
}
