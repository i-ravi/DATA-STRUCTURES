package GRAPH;

import java.io.*; 
import java.util.*; 

/**
 *
 * @author ravisharma
 */
public class DetectCycleUndirected {
    //V= No. of Nodes
    private int V;
    //Adjacency Matrix representation 
    LinkedList<Integer> adj[];
    
    DetectCycleUndirected(int v){
        V=v;
        adj=new LinkedList[V];
        for (int i=0;i<V;i++) adj[i]=new LinkedList();
    }
    
    void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    
    boolean isCyclicDFS(){
        //boolean array to mark visited nodes
        boolean vis[]=new boolean[V];
        for (int i=0;i<V;i++){
            if (!vis[i]){
                //calls helper method 
                if (isCyclicDFSHelper(i,vis,-1)) 
                    return true;
            }
        }
        return false;
    }
    //takes current node and its parent node as parameter with boolean array
    boolean isCyclicDFSHelper(int v,boolean[] vis,int parent){
        //marks current node as visited
        vis[v]=true;
        //iterates all the neighbouring nodes
        Iterator<Integer> it=adj[v].listIterator();
        int j;
        while(it.hasNext()){
            //j - neighbour node
            j=it.next();
            //if it is not visited than calls the method recursively with v as parent
            if (!vis[j]){
                if (isCyclicDFSHelper(j,vis,v)) 
                    return true;}
            //if it is visited and not parent of current vertex then cycle is detected
            else if (j!=parent) 
                return true;
        }
        return false;
    }
    
    boolean isCyclicBFS(){
        //boolean array to mark visited nodes
        boolean[] vis=new boolean[V];
        for (int i=0;i<V;i++){
            //calls helper method 
            if ((!vis[i]) && isCyclicBFSHelper(i,V,adj,vis))
                return true;
        }
        return false;
    }
    
    private boolean isCyclicBFSHelper(int s, int V, LinkedList<Integer>[] adj, boolean[] vis) {
        //maintains a parent arrays 
        int[] parent =new int[V];
        //fills all the nodes parent as -1 in the begining
        Arrays.fill(parent, -1);
        //queue is used as it is BFS
        Queue<Integer> q=new LinkedList<>();
        //marks starting node as visited
        vis[s]=true;
        //adds cuurent node in the queue
        q.add(s);
        while(!q.isEmpty()){
            //dequeue the node
            int t=q.poll();
            //visits all neighbour nodes
            for (int i=0;i<adj[t].size();i++){
                //take the neighbour node
                int v=adj[t].get(i);
                //if it is node visited then marks is visited
                //enqueue in the queue
                //and makes t as its parent
                if (!vis[v]){
                    vis[v]=true;
                    q.add(v);
                    parent[v]=t;
                }
                //if it is visited and not parent of current vertex then cycle is detected
                else if (parent[t]!=v) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        DetectCycleUndirected g1=new DetectCycleUndirected(5);
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4);             
        if(g1.isCyclicDFS())
            System.out.println("Cyclic");
        else 
            System.out.println("Not Cyclic");
        if(g1.isCyclicBFS())
            System.out.println("Cyclic");
        else 
            System.out.println("Not Cyclic");
        DetectCycleUndirected g2 = new DetectCycleUndirected(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        if(g2.isCyclicDFS())
            System.out.println("Cyclic");
        else 
            System.out.println("Not Cyclic");
        if(g2.isCyclicBFS())
            System.out.println("Cyclic");
        else 
            System.out.println("Not Cyclic");
        
    }
}
