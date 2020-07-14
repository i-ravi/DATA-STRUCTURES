/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAPH;

/**
 *
 * @author ravisharma
 */
import java.util.*;

// In DIRECTED GRAPH an extra boolean is maintained to check if node is visited or not for every iteration
public class DetectCycleDirected {
    
    int V;
    LinkedList<Integer> adj[];
    
    DetectCycleDirected(int v){
        V=v;
        adj=new LinkedList[V];
        for (int i=0;i<V;i++)
            adj[i]=new LinkedList();
    }
    
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    
    boolean isCyclicDFS(){
        boolean[] vis=new boolean[V];
        //rec is used to check if the element in the current iteration is visited or not
        boolean[] rec=new boolean[V];
        
        for (int i=0;i<V;i++){
            if (!vis[i]) 
                if(isCyclicDFSHelper(i,vis,rec)) 
                    return true;
        }
        return false;
    }
    
    boolean isCyclicDFSHelper(int v,boolean[] vis,boolean[] rec){
        vis[v]=true;
        rec[v]=true;
        Iterator<Integer> it=adj[v].listIterator();
        while(it.hasNext()){
            int u=it.next();
            
            if (!vis[u]){
                if(isCyclicDFSHelper(u,vis,rec)) 
                    return true;
            }
            //if the element is visited than the cycle is detected
            else if(rec[u]) return true;
        }
        //make it false once is it visited
        rec[v]=false;
        return false;
    }
    
    public static void main(String[] args) {
        DetectCycleDirected graph = new DetectCycleDirected(6); 
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        if(graph.isCyclicDFS()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle");
    }
}
