package GRAPH;

import java.util.Arrays;

/**
 *
 * @author ravisharma
 */
//Dijkstra’s algorithm is a Greedy algorithm and time complexity is O(VLogV) 
//(with the use of Fibonacci heap). Dijkstra doesn’t work for Graphs with 
//negative weight edges, Bellman-Ford works for such graphs. 
//Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. 
//But time complexity of Bellman-Ford is O(VE), which is more than Dijkstra.
public class BelmanFordAlgorithm {
   //A Graph to represent connected ,directed and weighted graph 
    class Edge{
      int src,dest,wt;
      Edge(){
          src=dest=wt=0;
      }
    };
    
    int V;
    int E;
    Edge edge[];
    //creates a graph with V vertices and E edges
    BelmanFordAlgorithm(int v,int e){
        V=v;
        E=e;
        edge=new Edge[e];
        for (int i=0;i<e;i++)
            edge[i]=new Edge();
    }
    //The main function that finds shortest distance from source to
    //all other vertices using belman ford algorithm 
    //The function also detects the negative weight cycle
    void belmanFordAlgorithm (BelmanFordAlgorithm g,int src){
        int V= g.V;
        int E= g.E;
        int[] dist=new int[V];
        //STEP 1: initializes all the distance from source as INFINITE
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src]=0;
        //STEP 2: Relax all edges |V|- 1 times. A simple
        //shortest path from src to any vertes can have at most |V|-1 edges
        for (int i=0;i<V;i++){
            for (int j=0;j<E;j++){
                int u=g.edge[j].src;
                int v=g.edge[j].dest;
                int wt=g.edge[j].wt;
                
                if(dist[u]!=Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v]=dist[u] + wt;
                }
            }
        }
        //Step 3: checks for negative-cycle.
        //The above steps guarantees shortest distance if graph
        //doesn't cantain negative cycle. 
        //If we get shorter path then there is a cycle.
        for (int i=0;i<E;i++){
           int u=g.edge[i].src;
                int v=g.edge[i].dest;
                int wt=g.edge[i].wt;
                
                if(dist[u]!=Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    System.out.println("Graph contains weight cycle"); 
                    return;}
                
        }
        printArr(dist,V);
    }
    
    //To print the distance from src to destination
    void printArr(int[] dist, int V){
        System.out.println("Vertex Distance from Source");
        for (int i=0;i<V;i++){
            System.out.println(i+"\t\t"+dist[i]);
        }
    }
    public static void main(String[] args) {
        int V=5; //No. of vertices in graph
        int E=8; //No.  of edges in graph
        BelmanFordAlgorithm g=new BelmanFordAlgorithm(V, E);
        
        g.edge[0].src=0;
        g.edge[0].dest=1;
        g.edge[0].wt=-1;
        
        g.edge[1].src=0;
        g.edge[1].dest=2;
        g.edge[1].wt=4;
        
        g.edge[2].src=1;
        g.edge[2].dest=2;
        g.edge[2].wt=3;
        
        g.edge[3].src=1;
        g.edge[3].dest=3;
        g.edge[3].wt=2;
        
        g.edge[4].src=3;
        g.edge[4].dest=1;
        g.edge[4].wt=1;
        
        g.edge[5].src=1;
        g.edge[5].dest=4;
        g.edge[5].wt=2;
        
        g.edge[6].src=4;
        g.edge[6].dest=3;
        g.edge[6].wt=-3;
        
        g.edge[7].src=3;
        g.edge[7].dest=2;
        g.edge[7].wt=5;
        
        g.belmanFordAlgorithm(g,0);
    }
    
    
}
