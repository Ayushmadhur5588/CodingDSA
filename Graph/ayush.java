package Graph;
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
   public static ArrayList<Edge>[] graph = new ArrayList[7];
   
   public static void main(String[] args){
    for(int i = 0; i < N; i++){
        graph[i] = new ArrayList<>();
    }
        addEdge(0, 1, 10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
    
        display();

    }
   
   
   public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
   }
   
   public static void display(){
    for(int i = 0; i < N; i++){
        System.out.print(i + "->" + " ");
        for(int j = 0; j < graph[i].size(); j++){
            Edge e = graph[i].get(j);
            System.out.print("(" + e + ")");
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
 
   }

   public static void removeVtx(int u){

   }

   
}
