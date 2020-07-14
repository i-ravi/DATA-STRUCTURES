package GRAPH;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ravisharma
 */

//This is Adjency List Representation
public class DFSGraph {
    //V = No. of Vertices
    private int V;
    //Array of List is used to store
    private LinkedList<Integer> adj[];
    //Contructor is used to  initialize the array of LinkedList
    DFSGraph(int v){
        V=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;i++)
            adj[i]=new LinkedList();
    }
    //Adds a edge into the graph
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    
    public static void main(String[] args) {
        DFSGraph g=new DFSGraph(6);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Depth First Traversal starting from 0");
        g.DFS(2);
    }
    
    void DFS(int v){
        //Marks all the vertices as not visited (Default)
        boolean vis[]=new boolean[V];
        //Calls the helper method
        DFSUtil(v,vis);
    }
    
    void DFSUtil(int v,boolean[] vis){
        //marks the current node visited and prints it
        vis[v]=true;
        System.out.print(v+" ");
        //iterates to all the neighbour nodes
        Iterator<Integer> i= adj[v].listIterator();
        
        while(i.hasNext()){
            int n=i.next();
            //visits the next node if it is not visited
            //it is a recursive process as DFS uses stack for implementation
            if (vis[n]==false) DFSUtil(n,vis);
        }
    }
    
}
